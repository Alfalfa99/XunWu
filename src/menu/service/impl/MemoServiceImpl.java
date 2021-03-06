package menu.service.impl;

import menu.dao.MemoDao;
import menu.dao.impl.MemoDaoImpl;
import menu.domain.Memo;
import menu.service.MemoService;

import java.util.List;
import java.util.Map;

public class MemoServiceImpl implements MemoService {
    private MemoDao memoDao = new MemoDaoImpl();
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

    @Override
    public void change_name(Integer id, String name) {
        memoDao.change_name(id, name);
    }

    @Override
    public Memo get_id(Integer equi_id, String location) {
        return memoDao.get_id(equi_id,location);
    }

    @Override
    public void deleteMemo(Integer equi_id) {
        memoDao.deleteMemo(equi_id);
    }
}
