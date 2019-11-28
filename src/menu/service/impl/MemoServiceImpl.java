package menu.service.impl;

import menu.dao.MemoDao;
import menu.dao.impl.MemoDaoImpl;
import menu.domain.Memo;
import menu.service.MemoService;

import java.util.List;
import java.util.Map;

public class MemoServiceImpl implements MemoService {
    MemoDao memoDao = new MemoDaoImpl();
    @Override
    public void add(Memo memo) {
        memoDao.add(memo);
    }

    @Override
    public void delete(Integer id) {
        memoDao.delete(id);
    }

    @Override
    public List<Map<String, Object>> findbyequi_id(Integer id) {
        return memoDao.findbyequi_id(id);
    }
}
