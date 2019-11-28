package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.service.EquipmentService;
import menu.service.MemoService;
import menu.service.impl.EquipmentServiceImpl;
import menu.service.impl.MemoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/delEquiServlet")
public class DelEquiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        EquipmentService equipmentService = new EquipmentServiceImpl();
        BufferedReader bufferReaderBody = null;
        try {
            bufferReaderBody = new BufferedReader(request.getReader());
            String postData = bufferReaderBody.readLine();
            ObjectMapper mapper = new ObjectMapper();
            postData = mapper.writeValueAsString(postData);
            postData = postData.substring(3, postData.length() - 1);
            equipmentService.delete(Integer.parseInt(postData));
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
