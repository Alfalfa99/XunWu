package menu.domain;

public class Change {
    private Integer id;
    private Integer equi_id;
    private String equi_nameo;
    private String equi_namen;
    private Integer addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEqui_id() {
        return equi_id;
    }

    public void setEqui_id(Integer equi_id) {
        this.equi_id = equi_id;
    }

    public String getEqui_nameo() {
        return equi_nameo;
    }

    public void setEqui_nameo(String equi_nameo) {
        this.equi_nameo = equi_nameo;
    }

    public String getEqui_namen() {
        return equi_namen;
    }

    public void setEqui_namen(String equi_namen) {
        this.equi_namen = equi_namen;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "change{" +
                "id=" + id +
                ", equi_id=" + equi_id +
                ", equi_nameo='" + equi_nameo + '\'' +
                ", equi_namen='" + equi_namen + '\'' +
                ", addtime=" + addtime +
                '}';
    }
}
