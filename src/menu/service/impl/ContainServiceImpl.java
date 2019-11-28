package menu.service.impl;

import menu.dao.ContainDao;
import menu.dao.impl.ContainDaoImpl;
import menu.domain.Contain;
import menu.service.ContainService;

public class ContainServiceImpl implements ContainService {
    ContainDao containDao = new ContainDaoImpl();
    @Override
    public void add(Contain contain) {
        containDao.add(contain);
    }

    @Override
    public void delete(Integer equi_id) {
        containDao.delete(equi_id);
    }

}
