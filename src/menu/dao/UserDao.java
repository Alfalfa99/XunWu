package menu.dao;

import menu.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 用户登录
     */
    User findUserByOpenid(String openid);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 用户拥有的所有设备
     */
    List<Map<String,Object>> list(String openid);

    /**
     * 删除用户
     */
    void delete(String openid);

    /**
     * 用md5
     */
    User findUserByMd5(String md5);
}
