package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.Memo;
import menu.service.MemoService;
import menu.service.impl.MemoServiceImpl;
import menu.util.TimeTransformer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/addmemoLocationServlet")
public class AddMemoLocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");

        Memo memo = new Memo();
        MemoService memoService = new MemoServiceImpl();
        TimeTransformer timeTransformer = new TimeTransformer();
        memo.setAddtime(timeTransformer.getNowTimeStamp());//为memo增加addtime
        BufferedReader bufferReaderBody = null;
        try {
            bufferReaderBody = new BufferedReader(request.getReader());
            String postData = bufferReaderBody.readLine();
            ObjectMapper mapper = new ObjectMapper();
            postData = mapper.writeValueAsString(postData);
            System.out.println(postData);
//            postData = postData.substring(3, postData.length() - 1);
            memoService.add(memo);
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
