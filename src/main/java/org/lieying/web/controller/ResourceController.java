package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import org.lieying.bean.Resource;
import org.lieying.core.CommonResult;
import org.lieying.core.ResultGenerator;
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
    @RequestMapping(value = "/{resourceId}")
    public CommonResult findResourceById(@PathVariable int resourceId){
        return ResultGenerator.genSuccessfulResult(resourceService.queryDetailResourceById(resourceId));
    }
}
