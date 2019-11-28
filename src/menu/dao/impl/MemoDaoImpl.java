package menu.dao.impl;

import menu.dao.MemoDao;
import menu.domain.Memo;
import menu.util.JDBCUtils;
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

}
