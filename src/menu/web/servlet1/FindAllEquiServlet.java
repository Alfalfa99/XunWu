package menu.web.servlet1;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = new HashMap<>();
        UserService userService = new UserServiceImpl();
        //把存储在session中的user对象取出来
        HttpSession session = request.getSession();
        Integer openid = (Integer) session.getAttribute("openid");
        List<Equipment> equipment = null;
        try {
            equipment = userService.findbyuser(openid);
            map.put("state",1);
        } catch (Exception e) {
            map.put("state",-1);
        }
        for (Equipment equipment1 : equipment) {
            map.put(equipment1.getEqui_name(),equipment1);
        }

        //将map转换为json,并传给客户端
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
