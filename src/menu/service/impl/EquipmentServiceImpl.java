package menu.service.impl;

import menu.dao.ContainDao;
import menu.dao.impl.ContainDaoImpl;
import menu.service.EquipmentService;
import menu.service.MemoService;

public class EquipmentServiceImpl implements EquipmentService {
    private ContainDao dao = new ContainDaoImpl();
    private MemoService memoService = new MemoServiceImpl();

    @Override
    public void add(Equipment equipment) {
        dao.add(equipment);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public void change(Equipment equipment) {
        dao.change(equipment);
        memoService.updateMemo(equipment);
    }
}
