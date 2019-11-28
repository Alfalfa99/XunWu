package menu.code;

public class ServiceManager {
    public static ServiceManager serviceManager;
    public ServiceManager(){
        serviceManager=this;
    }
    public void UpdateService(String msgPack){
        int middle=msgPack.indexOf(',');
        String id=msgPack.substring(middle);
        String signalStrength=msgPack.substring(middle,msgPack.length()-1);

        if(getServiceTime(id)>10){
            setServiceState(false);
        }



    }
    public int getServiceTime(String id){
        return 100;
    }
    public void setServiceState(boolean state){

    }
}
