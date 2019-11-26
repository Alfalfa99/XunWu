package menu.domain;

public class Equipment {
    private Integer id;
    private Integer user_id;
    private String equi_name;
    private Integer uuid;
    private Integer addtime;

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

    public String getEqui_name() {
        return equi_name;
    }

    public void setEqui_name(String equi_name) {
        this.equi_name = equi_name;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", equi_name='" + equi_name + '\'' +
                ", uuid=" + uuid +
                ", addtime=" + addtime +
                '}';
    }
}
