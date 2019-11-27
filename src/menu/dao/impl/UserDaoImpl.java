package menu.dao.impl;

import menu.dao.UserDao;
import menu.domain.Equipment;
import menu.domain.User;
import menu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void add(User user) {
        //添加用户
        String sql = "insert into user values(null,?,?,?)";
        template.update(sql, user.getUsername(), user.getOpenid(), user.getAddtime());
    }

    @Override
    public List<Equipment> findbyuser(Integer id) {
        //通过用户id查询所拥有的设备
        String sql = "select * from user where user_id = ?";
        List<Equipment> equipments = template.query(sql, new BeanPropertyRowMapper<>(Equipment.class),id);
        return equipments;
    }

    @Override
    public void delete(int openid) {
        //删除用户
        String sql = "delete from user where openid = ?";
        template.update(sql, openid);
    }
}
