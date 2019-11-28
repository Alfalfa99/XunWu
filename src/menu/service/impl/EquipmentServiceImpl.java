package menu.service.impl;

import menu.dao.EquipmentDao;
import menu.dao.impl.EquipmentDaoImpl;
import menu.domain.Equipment;
import menu.service.EquipmentService;

public class EquipmentServiceImpl implements EquipmentService {
        EquipmentDao equipmentDao = new EquipmentDaoImpl();
    @Override
    public void add(Equipment equipment) {
        equipmentDao.add(equipment);
    }

    @Override
    public void Wifi_name(Integer equi_id, String name) {
        equipmentDao.Wifi_name(equi_id, name);
    }

    @Override
    public void Wifi_password(Integer equi_id, String password) {
        equipmentDao.Wifi_password(equi_id,password);
    }

    @Override
    public void change_name(Integer id, String name) {
        equipmentDao.change_name(id,name);
    }

}
