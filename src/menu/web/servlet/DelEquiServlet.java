package menu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import menu.domain.Equipment;
import menu.domain.User;
import menu.service.ContainService;
import menu.service.EquipmentService;
import menu.service.MemoService;
import menu.service.UserService;
import menu.service.impl.ContainServiceImpl;
import menu.service.impl.EquipmentServiceImpl;
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
 * 解除设备绑定
 * post
 */
@WebServlet("/delEquiServlet")
public class DelEquiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String token = request.getHeader("token");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = new HashMap<String, Object>();
        ContainService containService = new ContainServiceImpl();   //调用解除绑定的方法
        UserService userService = new UserServiceImpl();    //调用过滤方法
        EquipmentService equipmentService = new EquipmentServiceImpl(); //将设备名改回默认名
        MemoService memoService = new MemoServiceImpl();    //删除该设备的全部记录
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
        if (id == null){
            responseMap.put("state",-1);
            mapper.writeValue(response.getWriter(), responseMap);
            return;
        }
        containService.delete(Integer.valueOf(id));
        Equipment equipment = equipmentService.find(Integer.valueOf(id));
        equipmentService.change_name(Integer.valueOf(id),String.valueOf(equipment.getEqui_uuid())); //解除绑定后设置为默认名
        memoService.deleteMemo(Integer.valueOf(id));
        responseMap.put("state",1);
        mapper.writeValue(response.getWriter(), responseMap);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
