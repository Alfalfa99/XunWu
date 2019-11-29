package menu.service;

import menu.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户的业务接口
 */
public interface UserService {
    /**
     * 查询用户所有的设备
     */
    List<Map<String,Object>> list(String id);

    /**
     * 增加用户
     */
    void add(User user);

    /**
     * 删除用户
     */
    void delete(String openid);

    /**
     * 查询是否有该用户
     */
    User findUserByOpenid(String openid);

    /**
     * 用md5
     */
    User findUserByMd5(String md5);
}
