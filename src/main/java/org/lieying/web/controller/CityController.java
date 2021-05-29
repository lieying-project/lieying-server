package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lieying.bean.City;
import org.lieying.core.CommonResult;
import org.lieying.core.ResultGenerator;
import org.lieying.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/all")
    public CommonResult getAllCities() {
        return ResultGenerator.genSuccessfulResult(cityService.queryAllCities());
    }
    /*
     *   根据多个拼首字母查询城市
     *   @param charStrs  多个字母拼接的字符串,如 characters="ABCD",则会查询出分别以A、B、C、D开头的城市信息
     */
    @ApiOperation(value = "根据多个拼首字母查询城市",notes = "根据多个拼首字母查询城市")
    @GetMapping(value = "/characters/{characters}")
    public CommonResult getCitiesByFirstCharacter(@PathVariable String characters) {
        return ResultGenerator.genSuccessfulResult(cityService.queryCitiesByMultipleCharacter(characters));
    }
    /*
    *  查询热门城市
    *
    */
    @ApiOperation(value = "查询热门城市",notes = "查询热门城市")
    @GetMapping(value = "/hot")
    public CommonResult getHotCities() {
        return ResultGenerator.genSuccessfulResult(cityService.queryHotCities());
    }

}
