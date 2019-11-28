package menu.web.servlet1;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.code.test;
import menu.domain.User;
import menu.service.UserService;
import menu.service.impl.UserServiceImpl;
import menu.util.JSONUtils;
import menu.util.TimeTransformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        JSONUtils jsonUtils = new JSONUtils();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("state",1);
        //先判断session中是否存有用户
        HttpSession session = request.getSession();
        User user1 = (User) session.getAttribute("user");
        String openid;
        String session_key;
        String unionId;
        //封装请求
        //封装User对象

        BufferedReader bufferReaderBody = null;

        try {
            bufferReaderBody = new BufferedReader(request.getReader());
            String postData = bufferReaderBody.readLine();
            postData = mapper.writeValueAsString(postData);
            String code = jsonUtils.main(postData,"code");
            String iv = jsonUtils.main(postData,"iv");
            String encryptedData = jsonUtils.main(postData,"encryptedData");
            //请求微信服务器获取用户openid以及加密秘钥
            test test = new test();
            String[] strings = test.main(code);
            openid = strings[0];
            session_key = strings[1];
            unionId = strings[2];
            User user = new User();
            UserService userService = new UserServiceImpl();
            user = userService.findUserByOpenid(Integer.valueOf(openid));

            if (user.getOpenid() == null) {
                User loginUser = userService.login(user);
                //调用通用方法获取当前时间
                TimeTransformer timeTransformer = new TimeTransformer();
                loginUser.setAddtime(timeTransformer.getNowTimeStamp());
                loginUser.setOpenid(Integer.valueOf(openid));
                //调用add方法将其加入数据库中
                userService.add(loginUser);
            } else {
                //如果已经注册那么不执行
            }
            //将用户存入session
            session.setAttribute("openid", openid);
            responseMap.put("state",1);
        } catch (IOException e) {
            responseMap.put("state",-1);
        } finally {
            if (bufferReaderBody != null) {
                bufferReaderBody.close();
            }
            mapper.writeValue(response.getWriter(),responseMap);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
