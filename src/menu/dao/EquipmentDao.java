package menu.dao;

import menu.domain.Equipment;

public interface EquipmentDao {
    /**
     * 添加设备
     */
    void add(Equipment equipment);

    /**
     * 删除设备
     */
    void delete(int id);


}
