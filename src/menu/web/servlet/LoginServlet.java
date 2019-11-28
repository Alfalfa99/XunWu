package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.code.test;
import menu.domain.User;
import menu.service.UserService;
import menu.service.impl.UserServiceImpl;
import menu.util.JSONUtils;
import menu.util.MD5Utils;
import menu.util.TimeTransformer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        JSONUtils jsonUtils = new JSONUtils();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = new HashMap<String, Object>();
        HttpSession session = null;
        String code = request.getParameter("code");
        String iv = request.getParameter("iv");
        String encryptedData = request.getParameter("encryptedData");
        //请求微信服务器获取用户openid以及加密秘钥
        test test = new test();
        String[] strings = test.main(code);
        String openid = strings[0];
        String session_key = strings[1];
        String unionId = strings[2];
        System.out.println(openid);
        User user = new User();
        UserService userService = new UserServiceImpl();
        user = userService.findUserByOpenid(Integer.valueOf(openid));
        String md5 = MD5Utils.string2MD5(openid);
        if (user.getOpenid() == null) {
            //调用通用方法获取当前时间
            TimeTransformer timeTransformer = new TimeTransformer();
            user.setAddtime(timeTransformer.getNowTimeStamp());
            user.setOpenid(Integer.valueOf(openid));
            //调用add方法将其加入数据库中
            userService.add(user);
        } else {
            //如果已经注册那么不执行
        }
        //将用户存入session
        session.setAttribute("openid", openid);
        session.setAttribute("id",user.getId());
        responseMap.put("state", 1);
        responseMap.put("token",md5);
        System.out.println(responseMap);
        mapper.writeValue(response.getWriter(), responseMap);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
