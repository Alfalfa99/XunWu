package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.Equipment;
import menu.domain.User;
import menu.service.UserService;
import menu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/findAllEquiServlet")
public class FindAllEquiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        UserService userService = new UserServiceImpl();
        //把存储在session中的user对象取出来
        User user;
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        List<Equipment> equipment = userService.findbyuser(user.getOpenid());

        Map<String,Object> map = new HashMap<>();
        for (Equipment equipment1 : equipment) {
            map.put(equipment1.getEqui_name(),equipment1);
        }

        //将map转换为json,并传给客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
