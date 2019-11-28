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
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addEquiServlet")
public class AddEquiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        HttpSession session = request.getSession();
        Integer openid = (Integer) session.getAttribute("openid");
        Equipment equipment = new Equipment();
        TimeTransformer timeTransformer = new TimeTransformer();
        equipment.setAddtime(timeTransformer.getNowTimeStamp());//为equipment增加addtime
        equipment.setUser_id(openid);     //为equipment增加User_id
        EquipmentService equipmentService = new EquipmentServiceImpl();
        BufferedReader bufferReaderBody = null;
        try {
            bufferReaderBody = new BufferedReader(request.getReader());
            String postData = bufferReaderBody.readLine();
            ObjectMapper mapper = new ObjectMapper();
            postData = mapper.writeValueAsString(postData);
            System.out.println(postData);
//            postData = postData.substring(3, postData.length() - 1);
            equipmentService.add(equipment);
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
