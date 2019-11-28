package menu.web.servlet1;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.service.MemoService;
import menu.service.impl.MemoServiceImpl;
import menu.util.JSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/DelMemoServlet")
public class DelMemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        JSONUtils jsonUtils = new JSONUtils();
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> responseMap = new HashMap<>();
//        String id = request.getHeader("token");
        MemoService memoService = new MemoServiceImpl();

        BufferedReader bufferReaderBody = null;
        try {
            bufferReaderBody = new BufferedReader(request.getReader());
            String postData = bufferReaderBody.readLine();
            postData = mapper.writeValueAsString(postData);
            String id = jsonUtils.main(postData,"id");
            String state = jsonUtils.main(postData,"token");
            if (state == null){
                responseMap.put("state",401);
                return;
            }
            memoService.delete(Integer.parseInt(id));
            responseMap.put("state",1);
        } catch (IOException e) {
            responseMap.put("state",-1);
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
