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
    public User findUserByOpenid(String openid) {
        try {
            String sql = "select id from user where openid = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), openid);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void add(User user) {
        //添加用户
        String sql = "insert into user values(null,?,?,?)";
        template.update(sql, user.getOpenid(), user.getAddtime(),user.getMd5());
    }

    @Override
    public List<Map<String,Object>> list(String md5) {
        //通过用户id查询所拥有的设备
        String sql = "SELECT id,equi_name as name FROM equipment WHERE id IN (SELECT equi_id FROM contain WHERE md5 = ?)";
        List<Map<String,Object>> list = template.queryForList(sql,md5);
        return list;
    }

    @Override
    public void delete(String openid) {
        //删除用户
        String sql = "delete from user where openid = ?";
        template.update(sql, openid);
    }

    @Override
    public User findUserByMd5(String md5) {
        try {
            String sql = "select * from user where md5 = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), md5);
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
