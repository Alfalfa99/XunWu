package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.User;
import menu.service.MemoService;
import menu.service.UserService;
import menu.service.impl.MemoServiceImpl;
import menu.service.impl.UserServiceImpl;
import menu.util.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 更新丢失记录接口
 * post
 */
@WebServlet("/updateMemoServlet")
public class UpdateMemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String token = request.getHeader("token");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = new HashMap<String, Object>();
        MemoService memoService = new MemoServiceImpl(); //调用为记录改名方法
        UserService userService = new UserServiceImpl();    //调用过滤方法
        User user;
        if (token == null){
            responseMap.put("state",401);
            mapper.writeValue(response.getWriter(), responseMap);
            return;
        }
        String md5 = MD5Utils.convertMD5(MD5Utils.convertMD5(token)); //MD5转回字符串
        user = userService.findUserByMd5(md5);
        if (user==null){
            responseMap.put("state",401);
            mapper.writeValue(response.getWriter(), responseMap);
            return;
        }
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        memoService.change_name(Integer.valueOf(id),name);
        responseMap.put("state",1);
        responseMap.put("name",name);
        mapper.writeValue(response.getWriter(), responseMap);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
