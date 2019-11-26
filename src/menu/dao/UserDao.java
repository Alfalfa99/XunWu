package menu.dao;

import menu.domain.Equipment;
import menu.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 用户注册
     * @param user
     */
    void add(User user);

    /**
     * 用户拥有的所有设备
     */
    List<Equipment> findall();

}
