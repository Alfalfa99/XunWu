package menu.dao.impl;

import menu.dao.EquipmentDao;
import menu.domain.Equipment;
import menu.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class EquipmentDaoImpl implements EquipmentDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void add(Equipment equipment) {
        //添加设备
        String sql = "update equi set equi_name = ? and addtime = ? where equi_uuid = ?";
        template.update(sql, equipment.getEqui_name(),equipment.getAddtime(),equipment.getUuid());
    }

    @Override
    public void delete(Integer id) {
        //删除设备
        String sql = "delete from equi where id = ?";
        template.update(sql, id);
    }

    @Override
    public void change(Equipment equipment, String newName) {
        //更改设备名
        String sql = "update equi set equi_name = ? where user_id = ? and equi_name = ?";
        template.update(sql, newName, equipment.getUser_id(), equipment.getEqui_name());
    }

}
