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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //先判断session中是否存有用户
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");

        //封装请求
        //封装User对象
        String regjson = request.getParameter("regjson");
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(regjson,User.class);


        if (user1 == null){//判断是否存在session
            //调用Service层查询是否已注册
            UserService userService = new UserServiceImpl();
            User loginUser = userService.login(user);
            if (loginUser == null){
                //调用通用方法获取当前时间
                TimeTransformer timeTransformer = new TimeTransformer();
                user.setAddtime(timeTransformer.getNowTimeStamp());
                //如果该用户尚未注册则调用add方法将其加入数据库中
                userService.add(user);
            }
            else{
                //如果已经注册那么不执行
            }
            //将用户存入session
            session.setAttribute("user",loginUser);
        }
        Cookie c = new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(60*60*24*30);
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
