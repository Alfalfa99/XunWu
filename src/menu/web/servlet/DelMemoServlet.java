package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.User;
import menu.service.EquipmentService;
import menu.service.MemoService;
import menu.service.UserService;
import menu.service.impl.EquipmentServiceImpl;
import menu.service.impl.MemoServiceImpl;
import menu.service.impl.UserServiceImpl;
import menu.util.TimeTransformer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/DelMemoServlet")
public class DelMemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String id = request.getHeader("token");
        MemoService memoService = new MemoServiceImpl();

        BufferedReader bufferReaderBody = null;
        try {
            bufferReaderBody = new BufferedReader(request.getReader());
            String postData = bufferReaderBody.readLine();
            ObjectMapper mapper = new ObjectMapper();
            postData = mapper.writeValueAsString(postData);
            postData = postData.substring(3, postData.length() - 1);
            memoService.delete(Integer.parseInt(postData));
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
