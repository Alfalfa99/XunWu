package menu.hardware;

public class ESPService {
    private boolean state=false;
    private long lastUpdateTime;
    private String id;
    private int SingnalStrength=0;

    public ESPService(String id1){
        id=id1;

    }
    private void setState(boolean state1){
        state=state1;
    }
    public void update(){
        setState(true);
        lastUpdateTime=CurrentTimeMillisClock.getInstance().now();
    }
    public void setSingnalStrength(int strength){
        SingnalStrength=strength;
        System.out.println("strength:"+strength);

    }
    public void checkTimeOut(long curtime){
        if(curtime-lastUpdateTime>10000){
            if(state==true){
                setState(false);
                System.out.println("Device:"+id+" Time Out");
            }

        }
    }
}
