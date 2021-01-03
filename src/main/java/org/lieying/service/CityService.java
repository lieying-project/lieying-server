package org.lieying.service;

import org.lieying.bean.City;

import java.util.List;
import java.util.Set;

public interface CityService {
     List<City> queryAllCities();
     List<City> queryCitiesByMultipleCharacter(String characters);
     List<City> queryHotCities();
}
