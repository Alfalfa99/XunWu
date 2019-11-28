package menu.dao;

import menu.domain.Equipment;

public interface EquipmentDao {
    /**
     * 增加设备
     */
    void add(Equipment equipment);

    /**
     * 更改热点名
     */
    void Wifi_name(Integer equi_id,String name);

    /**
     * 更改热点密码
     */
    void Wifi_password(Integer equi_id, String password);

    /**
     * 更该设备名
     */
    void change_name(Integer id, String name);

    /**
     * 通过id查看是否有该台设备
     */
    Equipment find(Integer id);
}
