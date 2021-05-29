package org.lieying.web.controller;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.lieying.bean.Information;
import org.lieying.core.CommonResult;
import org.lieying.core.ResultGenerator;
import org.lieying.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin
@Api(value = "资讯信息接口",tags = "咨询信息",hidden = false)
@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationService informationService;

    /*
     *  查询所有资讯
     *
     */
    @ApiOperation(value = "查询所有资讯",notes = "查询所有资讯")
    @GetMapping(value = "/all")
    public CommonResult getAllInformations(){
        return ResultGenerator.genSuccessfulResult(informationService.queryAllInformations());
    }

    /*
    * 根据咨询id查询咨询
    * */
    @ApiOperation(value = "根据资讯id查询咨询",notes = "根据资讯id查询咨询")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "id",name = "咨询编号",required = true,paramType = "INTEGER")
    )
    @GetMapping(value = "/{id}")
    public CommonResult getInformationById(@PathVariable int id){
        return  ResultGenerator.genSuccessfulResult(informationService.queryDetailInformationById(id));
    }

    /*
    *
    * 保存资讯信息
    * */
    @ApiOperation(value = "保存资讯信息",notes = "保存资讯信息")
    @PostMapping(value = "/save")
    public CommonResult saveInformation(@RequestBody Information information){
        return ResultGenerator.genEditSuccessfulResult(informationService.addInformation(information));
    }

}
