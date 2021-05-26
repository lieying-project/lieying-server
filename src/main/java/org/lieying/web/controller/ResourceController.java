package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import org.lieying.bean.Resource;
import org.lieying.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


    /*
    *  资源详情
    *  @param  resourceId  资源id
    */
    @RequestMapping(value = "/{resourceId}",produces = "text/plain;charset=UTF-8")
    public String findResourceById(@PathVariable int resourceId){
        return JSON.toJSONString(resourceService.queryDetailResourceById(resourceId));
    }
}
