package org.lieying.web.controller;
import com.alibaba.fastjson.JSON;
import org.lieying.bean.Information;
import org.lieying.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin
@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationService informationService;

    /*
     *  查询所有资讯
     *
     */
    @RequestMapping(value = "/all",produces = "text/plain;charset=UTF-8")
    public String getAllInformations(){
        return JSON.toJSONString(informationService.queryAllInformations());
    }

    @RequestMapping(value = "/{id}",produces = "text/plain;charset=UTF-8")
    public String getInformationById(@PathVariable int id){
        return JSON.toJSONString(informationService.queryDetailInformationById(id));
    }

    @PostMapping(value = "/save",produces = "text/plain;charset=UTF-8")
    public String saveInformation(@RequestBody Information information){
        return JSON.toJSONString(informationService.addInformation(information));
    }

}
