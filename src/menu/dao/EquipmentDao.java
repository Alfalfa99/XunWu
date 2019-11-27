package menu.dao;

import menu.domain.Equipment;

public interface EquipmentDao {
    /**
     * 添加设备
     */
    void add(Equipment equipment);

    /**
     * 根据用户id和设备名删除设备
     */
    void delete(Integer user_id, String equi_name);

    /**
     * 根据用户id和设备名更改设备名
     */
    void change(Integer user_id, String oldName, String newName);
}
