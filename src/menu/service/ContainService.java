package menu.service;

import menu.domain.Contain;

public interface ContainService {
    /**
     * 添加关系
     */
    void add(Contain contain);

    /**
     * 删除关系
     */
    void delete(Integer equi_id);
}
