package menu.service;

public interface EquipmentService {

    /**
     * 添加设备
     */
    void add(Equipment equipment);

    /**
     * 删除设备
     */
    void delete(Integer id);

    /**
     * 根据用户id和设备名更改设备名
     */
    void change(Equipment equipment);
}
