package menu.dao.impl;

import menu.dao.ContainDao;
import menu.domain.Contain;
import menu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ContainDaoImpl implements ContainDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public void add(Contain contain) {
        String sql = "insert into contain values(null,?,?,?)";
        template.update(sql, contain.getUser_id(), contain.getEqui_id(),contain.getAddtime());
    }

    @Override
    public void delete(Integer equi_id) {
        String sql = "delete from contain where equi_id = ?";
        template.update(sql, equi_id);
    }

    @Override
    public Contain search(Integer equi_id) {
        try {
            String sql = "select * from contain where equi_id = ?";
            Contain contain = template.queryForObject(sql, new BeanPropertyRowMapper<Contain>(Contain.class), equi_id);
            return contain;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
