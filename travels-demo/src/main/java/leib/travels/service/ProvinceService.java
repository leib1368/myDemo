package leib.travels.service;

import leib.travels.enity.Province;

import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/4/30 14:01
 */
public interface ProvinceService {
    List<Province> findByPage(Integer page,Integer rows);

    Integer findTotals();

    void saveProvince(Province province);

    void delete(String id);

    Province findOne(String id);

    void update(Province province);
}
