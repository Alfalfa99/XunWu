package menu.service.impl;

import menu.dao.UserDao;
import menu.dao.impl.UserDaoImpl;
import menu.domain.Equipment;
import menu.domain.User;
import menu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<Equipment> findbyuser(Integer id) {
        return dao.findbyuser(id);
    }

    @Override
    public User login(User user) {
        return dao.findUserByOpenid(user.getOpenid());
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void delete(int openid) {
        dao.delete(openid);
    }
}
