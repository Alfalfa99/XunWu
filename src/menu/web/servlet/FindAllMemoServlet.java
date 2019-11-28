package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findAllMemoServlet")
public class FindAllMemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String token = request.getHeader("token");
//        String openid = MD5Utils.convertMD5(token); //MD5转回字符串
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = new HashMap<String, Object>();
        MemoService memoService = new MemoServiceImpl();
        UserService userService = new UserServiceImpl();    //调用过滤方法
        User user;
        String openid = token;
        if(openid == null){
            responseMap.put("state",401);
            mapper.writeValue(response.getWriter(), responseMap);
            return;
        }
        user = userService.findUserByOpenid(Integer.valueOf(openid));

        if (user.getOpenid()==null){
            responseMap.put("state",401);
            mapper.writeValue(response.getWriter(), responseMap);
            return;
        }
        try {
            String id = request.getHeader("id");
            responseMap.put("state",1);
            responseMap.put("list",memoService.findbyequi_id(Integer.valueOf(id)));
            mapper.writeValue(response.getWriter(), responseMap);
        } catch (NumberFormatException e) {
            responseMap.put("state",401);
            mapper.writeValue(response.getWriter(), responseMap);
        } catch (IOException e) {
            responseMap.put("state",401);
            mapper.writeValue(response.getWriter(), responseMap);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}