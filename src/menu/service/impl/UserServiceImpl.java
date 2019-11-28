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
    public List<Map<String, Object>> list(Integer id) {
        return dao.list(id);
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void delete(Integer openid) {
        dao.delete(openid);
    }

    @Override
    public User findUserByOpenid(Integer openid) {
        return dao.findUserByOpenid(openid);
    }
}
