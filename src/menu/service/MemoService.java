package menu.service;

import menu.domain.Equipment;
import menu.domain.Memo;

import java.util.List;

public interface MemoService {
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
    List<Memo> findByequi_id(Integer id);

    /**
     * 设备名更改后对该表进行更新
     */
    void updateMemo(Equipment equipment);
}
