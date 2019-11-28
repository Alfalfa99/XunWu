package menu.dao;

import menu.domain.Contain;

public interface ContainDao {
    /**
     * 添加关系
     */
    void add(Contain contain);

    /**
     * 删除关系
     */
    void delete(Integer equi_id);

    /**
     * 查询该设备是否已经绑定
     */
    Contain search(Integer equi_id);

}
