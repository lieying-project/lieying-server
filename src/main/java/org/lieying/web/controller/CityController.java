package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lieying.bean.City;
import org.lieying.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@CrossOrigin
@Api(value = "城市信息接口",tags = "城市信息")
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     *    查询所有城市
     */
    @ApiOperation(value = "查询所有城市",notes = "查询所有城市")
    @RequestMapping(value = "/all", produces = "text/plain;charset=UTF-8")
    public String getAllCities() {
        return JSON.toJSONString(cityService.queryAllCities());
    }
    /*
     *   根据多个拼首字母查询城市
     *   @param charStrs  多个字母拼接的字符串,如 characters="ABCD",则会查询出分别以A、B、C、D开头的城市信息
     */
    @ApiOperation(value = "根据多个拼首字母查询城市",notes = "根据多个拼首字母查询城市")
    @RequestMapping(value = "/characters/{characters}", produces = "text/plain;charset=UTF-8")
    public String getCitiesByFirstCharacter(@PathVariable String characters) {
        return JSON.toJSONString(cityService.queryCitiesByMultipleCharacter(characters));
    }
    /*
    *  查询热门城市
    *
    */
    @ApiOperation(value = "查询热门城市",notes = "查询热门城市")
    @RequestMapping(value = "/hot", produces = "text/plain;charset=UTF-8")
    public String getHotCities() {
        return JSON.toJSONString(cityService.queryHotCities());
    }

}
