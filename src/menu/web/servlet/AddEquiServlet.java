package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.Contain;
import menu.domain.User;
import menu.service.ContainService;
import menu.service.UserService;
import menu.service.impl.ContainServiceImpl;
import menu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addEquiServlet")
public class AddEquiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getHeader("token");
//        String openid = MD5Utils.convertMD5(token); //MD5转回字符串
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = new HashMap<String, Object>();
        ContainService containService = new ContainServiceImpl();   //增加绑定
        Contain contain = new Contain();
        UserService userService = new UserServiceImpl();    //调用过滤方法
        User user;
        String openid = token;
        if(openid == null){
            responseMap.put("state",401);
            mapper.writeValue(response.getWriter(), responseMap);
            return;
        }
        user = userService.findUserByOpenid(Integer.valueOf(openid));
        if (user.getOpenid()==null){
            responseMap.put("state",401);
            mapper.writeValue(response.getWriter(), responseMap);
            return;
        }
        String id = request.getParameter("id");
        contain.setEqui_id(Integer.valueOf(id));
        contain.setUser_id(user.getId());
        containService.add(contain);
        responseMap.put("state",1);
        mapper.writeValue(response.getWriter(), responseMap);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
