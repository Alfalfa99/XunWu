//package menu.web.servlet1;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import menu.service.EquipmentService;
//import menu.service.impl.EquipmentServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet("/updateEquiNameServlet")
//public class UpdateEquiNameServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json;charset=utf-8");
//        Map<String, Object> responseMap = new HashMap<String, Object>();
////        String json = request.getHeader("token");
//        ObjectMapper mapper = new ObjectMapper();
//        Equipment equipment = new Equipment();
//        EquipmentService equipmentService = new EquipmentServiceImpl();
//        BufferedReader bufferReaderBody = null;
//        try {
//            bufferReaderBody = new BufferedReader(request.getReader());
//            String postData = bufferReaderBody.readLine();
////            postData = mapper.writeValueAsString(postData);
////            equipment.setUser_id(Integer.valueOf());
////            equipmentService.change(equipment);
////            if ()
//        } catch (IOException e){
//            responseMap.put("state",-1);
//            return;
//        } finally {
//            if (bufferReaderBody != null) {
//                bufferReaderBody.close();
//            }
//        }
//        try {
//            equipmentService.change(equipment);
//            responseMap.put("state",1);
//        } catch (Exception e) {
//            responseMap.put("state",-1);
//        }
//        finally {
//            mapper.writeValue(response.getWriter(),responseMap);
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
//
//
//
//
//
//
//
//
//
//
