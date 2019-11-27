package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.Equipment;
import menu.domain.Memo;
import menu.domain.User;
import menu.service.MemoService;
import menu.service.UserService;
import menu.service.impl.MemoServiceImpl;
import menu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addmemoLocationServlet")
public class AddMemoLocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        String memojson = request.getParameter("memojson");
        ObjectMapper mapper = new ObjectMapper();
        Memo memo = mapper.readValue(memojson,Memo.class);
        MemoService memoService = new MemoServiceImpl();
        memoService.add(memo);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
