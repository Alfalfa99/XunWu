package menu.domain;

public class User {
    private Integer id;
    private Integer openid;
    private Integer addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOpenid() {
        return openid;
    }

    public void setOpenid(Integer openid) {
        this.openid = openid;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openid=" + openid +
                ", addtime=" + addtime +
                '}';
    }
}
