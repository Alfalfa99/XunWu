package menu.domain;

public class Contain {
    private Integer id;
    private Integer user_id;
    private Integer equi_id;
    private Integer addtime;
    private String md5;

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getEqui_id() {
        return equi_id;
    }

    public void setEqui_id(Integer equi_id) {
        this.equi_id = equi_id;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }
}
