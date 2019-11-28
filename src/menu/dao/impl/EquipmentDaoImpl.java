package menu.dao.impl;

import menu.dao.EquipmentDao;
import menu.domain.Equipment;
import menu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EquipmentDaoImpl implements EquipmentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void add(Equipment equipment) {
        String sql = "insert into equipment values(null,?,?,?,?,?)";
        template.update(sql, equipment.getEqui_wifiname(), equipment.getEqui_wifipassword(),equipment.getEqui_uuid(),equipment.getAddtime(),equipment.getEqui_uuid());
    }

    @Override
    public void Wifi_name(Integer equi_id, String name) {
        String sql = "update equipment set equi_name = ? where id = ?";
        template.update(sql, name, equi_id);
    }

    @Override
    public void Wifi_password(Integer equi_id, String password) {
        String sql = "update equipment set equi_name = ? where id = ?";
        template.update(sql, password, equi_id);
    }

    @Override
    public void change_name(Integer id, String name) {
        String sql = "update equipment set equi_name = ? where id = ?";
        template.update(sql, name, id);
    }

    @Override
    public Equipment find(Integer id) {
        try {
            String sql = "select * from equipment where id = ?";
            Equipment equipment = template.queryForObject(sql, new BeanPropertyRowMapper<Equipment>(Equipment.class), id);
            return equipment;
        } catch (Exception e) {
            return null;
        }
    }
}
