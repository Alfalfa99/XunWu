package menu.dao.impl;

import menu.dao.MemoDao;
import menu.domain.Memo;
import menu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
        String sql = "delete from equi where id = ?";
        template.update(sql, id);
    }

    @Override
    public List<Memo> findbyid(Integer id) {
        String sql = "select * from user where equi_id = ?";
        List<Memo> memos = template.query(sql, new BeanPropertyRowMapper<>(Memo.class),id);
        return memos;
    }
}
