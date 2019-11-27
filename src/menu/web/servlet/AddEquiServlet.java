package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.Equipment;
import menu.domain.User;
import menu.service.EquipmentService;
import menu.service.impl.EquipmentServiceImpl;
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

@WebServlet("/addEquiServlet")
public class AddEquiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        String json = request.getParameter("addjson");  //addjson里一定要有uuid,设备名
        ObjectMapper mapper = new ObjectMapper();
        Equipment equipment = mapper.readValue(json, Equipment.class);
        TimeTransformer timeTransformer = new TimeTransformer();
        equipment.setAddtime(timeTransformer.getNowTimeStamp());//为equipment增加addtime
        equipment.setUser_id(user.getOpenid());     //为equipment增加User_id
        EquipmentService equipmentService = new EquipmentServiceImpl();
        equipmentService.add(equipment);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
