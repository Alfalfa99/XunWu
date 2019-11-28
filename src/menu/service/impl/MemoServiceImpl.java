package menu.service.impl;

import menu.dao.MemoDao;
import menu.dao.impl.MemoDaoImpl;
import menu.domain.Equipment;
import menu.domain.Memo;
import menu.service.MemoService;

import java.util.List;

public class MemoServiceImpl implements MemoService {
    private MemoDao dao = new MemoDaoImpl();

    @Override
    public void add(Memo memo) {
        dao.add(memo);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public List<Memo> findByequi_id(Integer id) {
        return dao.findbyequi_id(id);
    }

    @Override
    public void updateMemo(Equipment equipment) {
        dao.updateMemo(equipment);
    }
}
