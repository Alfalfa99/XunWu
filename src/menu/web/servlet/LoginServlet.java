package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.User;
import menu.service.UserService;
import menu.service.impl.UserServiceImpl;
import menu.util.TimeTransformer;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //先判断session中是否存有用户
        HttpSession session = request.getSession();
        User user1 = (User) session.getAttribute("user");

        //封装请求
        //封装User对象

        BufferedReader bufferReaderBody = null;

        try {
            bufferReaderBody = new BufferedReader(request.getReader());
            String postData = bufferReaderBody.readLine();

            ObjectMapper mapper = new ObjectMapper();
            postData = mapper.writeValueAsString(postData);

            int head = postData.indexOf("code=");
            int end = postData.indexOf("&");
            String code = postData.substring(head+5, end);
            postData = postData.substring(end+1, postData.length()) ;
            head = postData.indexOf("iv=");
            end = postData.indexOf("&");
            String iv = postData.substring(head+3, end);
            postData = postData.substring(end+1, postData.length() - 1);
            head = postData.indexOf("encryptedData=");
            end = postData.indexOf("&");
            String encryptedData = postData.substring(head+14, postData.length()-1);
            //请求微信服务器获取用户openid以及加密秘钥

            if (openid == null) {
                User user = new User();
                UserService userService = new UserServiceImpl();
                User loginUser = userService.login(user);
                //调用通用方法获取当前时间
                TimeTransformer timeTransformer = new TimeTransformer();
                user.setAddtime(timeTransformer.getNowTimeStamp());
                //如果该用户尚未注册则调用add方法将其加入数据库中
                userService.add(user);
            } else {
                //如果已经注册那么不执行
            }
            //将用户存入session
            session.setAttribute("openid", openid);

        } catch (IOException e) {

            throw e;

        } finally {

            if (bufferReaderBody != null) {
                bufferReaderBody.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
