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

@WebServlet("/updateEquiNameServlet")
public class UpdateEquiNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        User user = new User();
        HttpSession session = request.getSession();
        String json = request.getParameter("updatejson");
        ObjectMapper mapper = new ObjectMapper();
        Equipment equipment = mapper.readValue(json, Equipment.class);
        EquipmentService equipmentService = new EquipmentServiceImpl();
        equipmentService.change(equipment);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
