package org.lieying.dao;

import cn.pomit.jpamapper.core.mapper.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lieying.bean.City;

import java.util.List;

@Mapper
public interface CityMapper extends CrudMapper<City,Integer> {

    List<City> selectCitiesByCharacter(@Param("c") String c);
    List<City> selectHotCities();
    List<City> selectAllCities();
}
