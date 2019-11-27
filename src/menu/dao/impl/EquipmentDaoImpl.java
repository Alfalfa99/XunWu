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
        String sql = "insert into equi values(null,?,?,?)";
        template.update(sql, equipment.getUser_id(), equipment.getEqui_name(), equipment.getUuid(),equipment.getAddtime());
    }

    @Override
    public void delete(Integer user_id, String equi_name) {
        //删除设备
        String sql = "delete from equi where user_id = ? and equi_name = ?";
        template.update(sql, user_id, equi_name);
    }

    @Override
    public void change(Integer user_id, String oldName, String newName) {

    }

}
