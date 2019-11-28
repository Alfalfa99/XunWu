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
    public User findUserByOpenid(Integer openid) {
        try {
            String sql = "select * from user where openid = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), openid);
            return user;
        } catch (Exception e) {
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
        String sql = "SELECT id,equi_name as name FROM equipment WHERE id IN (SELECT equi_id FROM contain WHERE user_id = ?)";
        List<Map<String,Object>> list = template.queryForList(sql,id);
        return list;
    }

    @Override
    public void delete(Integer openid) {
        //删除用户
        String sql = "delete from user where openid = ?";
        template.update(sql, openid);
    }
}
