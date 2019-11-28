package menu.service;

import menu.domain.Memo;

import java.util.List;
import java.util.Map;

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
    List<Map<String,Object>> findbyequi_id(Integer id);
}
