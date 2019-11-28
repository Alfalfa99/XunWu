package menu.domain;

public class Equipment {
    Integer id;
    String equi_wifiname;
    String equi_wifipassword;
    Integer equi_uuid;
    Integer addtime;
    String equi_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEqui_wifiname() {
        return equi_wifiname;
    }

    public void setEqui_wifiname(String equi_wifiname) {
        this.equi_wifiname = equi_wifiname;
    }

    public String getEqui_wifipassword() {
        return equi_wifipassword;
    }

    public void setEqui_wifipassword(String equi_wifipassword) {
        this.equi_wifipassword = equi_wifipassword;
    }

    public Integer getEqui_uuid() {
        return equi_uuid;
    }

    public void setEqui_uuid(Integer equi_uuid) {
        this.equi_uuid = equi_uuid;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public String getEqui_name() {
        return equi_name;
    }

    public void setEqui_name(String equi_name) {
        this.equi_name = equi_name;
    }
}
