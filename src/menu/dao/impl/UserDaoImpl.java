package menu.dao.impl;

import menu.dao.UserDao;
import menu.domain.User;
import menu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public User findUserByOpenid(int openid) {
        try {
            String sql = "select * from user where openid = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), openid);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        //添加用户
        String sql = "insert into user values(null,?,?)";
        template.update(sql, user.getOpenid(), user.getAddtime());
    }

    @Override
    public List<Map<String,Object>> list(Integer id) {
        //通过用户id查询所拥有的设备
        String sql = "select equi_id and equi_name from contain, equipment where user_id = ? and equipment.id = contain.equi_id";
        List<Map<String,Object>> list = template.queryForList(sql,id);
        return list;
    }

    @Override
    public void delete(int openid) {
        //删除用户
        String sql = "delete from user where openid = ?";
        template.update(sql, openid);
    }
}
