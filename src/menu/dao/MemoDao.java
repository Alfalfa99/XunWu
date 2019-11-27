package menu.dao;

import menu.domain.Equipment;
import menu.domain.Memo;

import java.util.List;

public interface MemoDao {
    /**
     * 增加设备丢失记录
     */
    void add(Memo memo);

    /**
     * 删除设备丢失记录
     */
    void delete(Integer id);

    /**
     * 展示该台设备的全部丢失记录
     */
    List<Memo> findbyequi_id(Integer id);

    /**
     * 设备名更改后对该表进行更新
     */
    void updateMemo(Equipment equipment, String newName);
}
