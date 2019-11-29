package menu.hardware;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServiceManager {
    private static ServiceManager serviceManager;
    Map<String,ESPService> serviceMap = new HashMap<String, ESPService>();

    private ServiceManager(){
        serviceManager=this;
        addNewService("11111");
        addNewService("11112");
        addNewService("*1234");
        InitCheckAllServiceTimeOut();
    }
    public void addNewService(String id){
        serviceMap.put(id,new ESPService(id));

    }
    public static ServiceManager getInstance(){
        if (serviceManager==null){
            serviceManager=new ServiceManager();
        }
        return serviceManager;
    }
    public ESPService getServiceByID(String id){
        return serviceMap.get(id);
    }
    public void UpdateService(String msgPack){
        int middle=msgPack.indexOf(',');
        String id=msgPack.substring(0,middle);
        String signalStrength=msgPack.substring(middle+1,msgPack.length());

        System.out.println("id: "+id+" rssi: "+signalStrength);
        System.out.println(msgPack);

        ESPService target=getServiceByID(id);

        if(target!=null){
            target.setSingnalStrength(Integer.parseInt( signalStrength ));
            target.update();
        }else{
            System.out.println("Device not existed");

        }



    }
    private void InitCheckAllServiceTimeOut() {
        new ScheduledThreadPoolExecutor(1, runnable -> {
            Thread thread = new Thread(runnable, "current-time-millis");
            thread.setDaemon(true);
            return thread;
        }).scheduleAtFixedRate(() -> {
            long curtime=CurrentTimeMillisClock.getInstance().now();
            Iterator<String> iter = serviceMap.keySet().iterator();
            while (iter.hasNext()) {
                ESPService es = serviceMap.get(iter.next());
                es.checkTimeOut(curtime);

            }
        }, 1, 5, TimeUnit.SECONDS);
    }
}
