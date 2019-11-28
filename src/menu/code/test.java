package menu.code;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
public class test {

    private static final String APPID = "wxc55eb61a92436a1b";// 微信应用唯一标识
    private static final String SECRET = "04d66c08c762073c9cbbaf74b8bcdd77";

    public String[] main(String code) {

        JSONObject jsonObject = code2sessionKey(code);

        String openId = jsonObject.getString("openid");// 用户唯一标识

        String session_key = jsonObject.getString("session_key");// 密钥

        // 满足UnionID下发条件的情况下，返回
        String unionId = jsonObject.getString("unionid");
        String[] strings = {openId,session_key,unionId};
        return strings;
    }

    /**
     * 发送请求用code换取sessionKey和相关信息
     *
     * @param code
     * @return
     */
    public static com.alibaba.fastjson.JSONObject code2sessionKey(String code) {
        String stringToken = String.format(
                "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                APPID, SECRET, code);
        String response = httpsRequestToString(stringToken, "GET", null);
        return JSON.parseObject(response);
    }

    /**
     * 发送https请求
     *
     * @param path
     * @param method
     * @param body
     * @return
     */
    public static String httpsRequestToString(String path, String method, String body) {
        if (path == null || method == null) {
            return null;
        }
        String response = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        HttpsURLConnection conn = null;
        try {
            // 创建SSLConrext对象，并使用我们指定的信任管理器初始化
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            TrustManager[] tm = { new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }


                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

            } };
            sslContext.init(null, tm, new java.security.SecureRandom());

            // 从上面对象中得到SSLSocketFactory
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(path);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            // 设置请求方式（get|post）
            conn.setRequestMethod(method);

            // 有数据提交时
            if (null != body) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(body.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            inputStream = conn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            response = buffer.toString();
        } catch (Exception e) {

        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            try {
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException execption) {

            }
        }
        return response;
    }
}