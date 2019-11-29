package menu.dao.impl;

import menu.dao.MemoDao;
import menu.domain.Memo;
import menu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class MemoDaoImpl implements MemoDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void add(Memo memo) {
        //添加记录
        String sql = "insert into memo values(null,?,?,?)";
        template.update(sql, memo.getEqui_id(), memo.getLast_location(), memo.getAddtime());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from memo where id = ?";
        template.update(sql, id);
    }

    @Override
    public List<Map<String,Object>> findbyequi_id(Integer id) {
        String sql = "select id, last_location as name, addtime as time from memo where equi_id = ?";
        List<Map<String,Object>> memos = template.queryForList(sql,id);
        return memos;
    }

    @Override
    public void change_name(Integer id, String name) {
        String sql = "update memo set last_location = ? where id = ?";
        template.update(sql, name, id);
    }

    @Override
    public Memo get_id(Integer equi_id, String location) {
        try {
            String sql = "select * from memo where equi_id = ? and last_location = ?";
            Memo memo = template.queryForObject(sql, new BeanPropertyRowMapper<Memo>(Memo.class), equi_id,location);
            return memo;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteMemo(Integer equi_id) {
        String sql = "delete from memo where equi_id = ?";
        template.update(sql, equi_id);
    }

}
