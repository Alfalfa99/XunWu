package menu.dao;

import menu.domain.Memo;

import java.util.List;

public interface MemoDao {
    /**
     * 增加设备丢失记录
     */
    void add(Memo memo);

    /**
     * 根据用户id和设备名删除设备丢失记录
     */
    void delete(Integer id);

    /**
     * 展示该台设备的全部丢失记录
     */
    List<Memo> findbyuser();
}
