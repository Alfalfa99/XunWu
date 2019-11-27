package menu.dao.impl;

import menu.dao.MemoDao;
import menu.domain.Memo;
import menu.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MemoDaoImpl implements MemoDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void add(Memo memo) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Memo> findbyuser() {
        return null;
    }
}
