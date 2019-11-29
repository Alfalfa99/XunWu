package menu.service.impl;

import menu.dao.UserDao;
import menu.dao.impl.UserDaoImpl;
import menu.domain.User;
import menu.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();


    @Override
    public List<Map<String, Object>> list(String openid) {
        return dao.list(openid);
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void delete(String openid) {
        dao.delete(openid);
    }

    @Override
    public User findUserByOpenid(String openid) {
        return dao.findUserByOpenid(openid);
    }

    @Override
    public User findUserByMd5(String md5) {
        return dao.findUserByMd5(md5);
    }
}
