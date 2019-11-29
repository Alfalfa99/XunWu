package menu.dao;

import menu.domain.Memo;

import java.util.List;
import java.util.Map;

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
    List<Map<String,Object>> findbyequi_id(Integer id);

    /**
     * 更改设备丢失记录
     */
    void change_name(Integer id, String name);

    /**
     * 获得某次丢失记录的id
     */
    Memo get_id(Integer equi_id, String location);

    /**
     * 删除设备的全部记录
     */
    void deleteMemo(Integer equi_id);
}
