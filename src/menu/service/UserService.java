package menu.service;

import menu.domain.Equipment;
import menu.domain.User;

import java.util.List;

/**
 * 用户的业务接口
 */
public interface UserService {
    /**
     * 查询用户所有的设备
     */
    List<Equipment> findbyuser(Integer id);

    /**
     * 登录方法
     */
    User login(User user);

    /**
     * 增加用户
     */
    void add(User user);

    /**
     * 删除用户
     */
    void delete(int openid);
}
