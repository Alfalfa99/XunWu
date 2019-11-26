package menu.domain;

public class memo {
    private Integer id;
    private Integer equi_id;
    private String last_location;
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

    public String getLast_location() {
        return last_location;
    }

    public void setLast_location(String last_location) {
        this.last_location = last_location;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "memo{" +
                "id=" + id +
                ", equi_id=" + equi_id +
                ", last_location='" + last_location + '\'' +
                ", addtime=" + addtime +
                '}';
    }
}
