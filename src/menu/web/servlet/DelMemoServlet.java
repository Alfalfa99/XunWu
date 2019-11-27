package menu.web.servlet;

import menu.service.EquipmentService;
import menu.service.MemoService;
import menu.service.impl.EquipmentServiceImpl;
import menu.service.impl.MemoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelMemoServlet")
public class DelMemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String id = request.getParameter("id");
        MemoService memoService = new MemoServiceImpl();
        memoService.delete(Integer.parseInt(id));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
