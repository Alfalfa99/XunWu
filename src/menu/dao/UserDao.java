package menu.dao;

import menu.domain.Equipment;
import menu.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 用户登录
     */
    User findUserByOpenid(int openid);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 用户拥有的所有设备
     */
    List<Equipment> findbyuser(Integer id);

    /**
     * 删除用户
     */
    void delete(int openid);
}
