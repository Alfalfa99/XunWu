package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.Memo;
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
 * 增加丢失记录接口
 * post
 */
@WebServlet("/addMemoServlet")
public class AddMemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String token = request.getHeader("token");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = new HashMap<String, Object>();
        MemoService memoService = new MemoServiceImpl();   //增加绑定
        Memo memo = new Memo();
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
        String location = request.getParameter("name");
        String timeStamp = request.getParameter("time");
        memo.setEqui_id(Integer.valueOf(id));
        memo.setLast_location(location);
        memo.setAddtime(Long.valueOf(timeStamp));
        memoService.add(memo);
        memo = memoService.get_id(memo.getEqui_id(),memo.getLast_location());
        responseMap.put("state",1);
        responseMap.put("id",memo.getId());
        responseMap.put("name",memo.getLast_location());
        responseMap.put("time",memo.getAddtime());
        mapper.writeValue(response.getWriter(), responseMap);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
