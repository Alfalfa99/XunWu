package menu.service.impl;

import menu.dao.EquipmentDao;
import menu.dao.impl.EquipmentDaoImpl;
import menu.domain.Equipment;
import menu.service.EquipmentService;
import menu.service.MemoService;

public class EquipmentServiceImpl implements EquipmentService {
    private EquipmentDao dao = new EquipmentDaoImpl();
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
    public void change(Equipment equipment, String newName) {
        dao.change(equipment, newName);
        memoService.updateMemo(equipment,newName);
    }
}
