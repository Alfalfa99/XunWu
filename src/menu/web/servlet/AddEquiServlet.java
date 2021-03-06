package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.Contain;
import menu.domain.Equipment;
import menu.domain.User;
import menu.service.ContainService;
import menu.service.EquipmentService;
import menu.service.UserService;
import menu.service.impl.ContainServiceImpl;
import menu.service.impl.EquipmentServiceImpl;
import menu.service.impl.UserServiceImpl;
import menu.util.MD5Utils;
import menu.util.TimeTransformer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 为用户增加设备增加设备接口
 * Post
 */

@WebServlet("/addEquiServlet")
public class AddEquiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String token = request.getHeader("token");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = new HashMap<String, Object>();
        ContainService containService = new ContainServiceImpl();   //增加绑定
        Contain contain = new Contain();
        EquipmentService equipmentService = new EquipmentServiceImpl();
        UserService userService = new UserServiceImpl();    //调用过滤方法
        User user = new User();
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
        contain = containService.search(Integer.valueOf(id));
        if (contain!=null){
            responseMap.put("state",-1);
            mapper.writeValue(response.getWriter(), responseMap);
            return;
        }
        Equipment equipment = equipmentService.find(Integer.valueOf(id));
        if (equipment==null){
            responseMap.put("state",-1);
            mapper.writeValue(response.getWriter(), responseMap);
            return;
        }
        contain = new Contain();
        TimeTransformer timeTransformer = new TimeTransformer();
        contain.setEqui_id(equipment.getId());
        contain.setUser_id(user.getId());
        contain.setMd5(user.getMd5());
        contain.setAddtime(timeTransformer.getNowTimeStamp());
        containService.add(contain);
        responseMap.put("state",1);
        responseMap.put("id",equipment.getId());
        responseMap.put("name",equipment.getEqui_name());
        mapper.writeValue(response.getWriter(), responseMap);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
