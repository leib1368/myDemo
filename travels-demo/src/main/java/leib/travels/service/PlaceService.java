package leib.travels.service;

import leib.travels.enity.Place;

import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/5/1 14:30
 */
public interface PlaceService {


    List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId);


    Integer findByProvinceIdCounts(String provinceId);


    void save(Place place);

    void delete(String id);

    Place findOne(String id);

    void update(Place place);
}
