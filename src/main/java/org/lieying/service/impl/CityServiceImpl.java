package org.lieying.service.impl;

import org.lieying.bean.City;
import org.lieying.dao.CityMapper;
import org.lieying.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service(value = "cityService")
public class CityServiceImpl  implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Cacheable(value = "cache1")
    @Transactional(readOnly = true)
    @Override
    public List<City> queryAllCities() {
       // return (List<City>) cityMapper.findAll();
        return cityMapper.selectAllCities();
    }


    @Override
    public List<City> queryCitiesByMultipleCharacter(String characters) {
        List<City> cities=new ArrayList<>();
        for (int i=0;i<characters.length();i++){
            char c = characters.charAt(i);
            cities.addAll(cityMapper.selectCitiesByCharacter(String.valueOf(c)));
        }
        return cities;
    }

    @Override
    public List<City> queryHotCities() {
        return cityMapper.selectHotCities();
    }


}
