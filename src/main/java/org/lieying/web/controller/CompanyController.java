package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.lieying.bean.*;
import org.lieying.core.CommonResult;
import org.lieying.core.ResultGenerator;
import org.lieying.service.CompanyScaleService;
import org.lieying.service.CompanyService;
import org.lieying.service.FinancingStageService;
import org.lieying.service.IndustryService;
import org.lieying.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

//@CrossOrigin
@Api(value = "公司信息接口",tags = "公司信息")
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private FinancingStageService financingStageService;
    @Autowired
    private CompanyScaleService companyScaleService;
    @Autowired
    private IndustryService industryService;

    /*
     * 公司详情
     * @param  id  公司id
     */
    @ApiOperation(value = "公司详情",notes = "根据格式编号查询公司信息")
    @GetMapping(value = "/{id}")
    public CommonResult getCompanyById(@PathVariable("id") int id) {
        return ResultGenerator.genSuccessfulResult(companyService.queryCompanyById(id));
    }

    /*
     * 多条件查询公司信息
     * @param   cityId             城市id
     * @param   industryId         公司行业id
     * @param   financingStageId   融资阶段id
     * @param   companyScaleId     公司规模id
     * */
    @ApiOperation(value = "多条件查询公司信息",notes = "多条件查询公司信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "cityId",name = "城市编号",required = false,paramType = "query", dataType = "INTEGER"),
            @ApiImplicitParam(value = "industryId",name = "产业编号",required = false,paramType = "query", dataType = "INTEGER"),
            @ApiImplicitParam(value = "financingStageId",name = "融资阶段编号",required = false,paramType = "query", dataType = "INTEGER"),
            @ApiImplicitParam(value = "companyScaleId",name = "公司规模编号",required = false,paramType = "query", dataType = "INTEGER")
    })
    @GetMapping(value = "")
    public CommonResult getCompanyByCriteria(@RequestParam(value = "cityId", required = false) Integer cityId,
                                       @RequestParam(value = "industryId", required = false) Integer industryId,
                                       @RequestParam(value = "financingStageId", required = false) Integer financingStageId,
                                       @RequestParam(value = "companyScaleId", required = false) Integer companyScaleId) {

        List<Company> companies = companyService.queryCompaniesByCriteria(cityId, industryId, financingStageId, companyScaleId);
        System.out.println(cityId + " " + industryId + " " + financingStageId + " " + companyScaleId);
        System.out.println(companies.size());
        return ResultGenerator.genSuccessfulResult(companies);
    }

    /*
     *  查询热门公司
     *  @param  cityId 城市id
     */
    @ApiOperation(value = "查询热门公司",notes = "查询热门公司")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "cityId",name = "城市编号",required = false,paramType = "query", dataType = "INTEGER"),
    })
    @GetMapping(value = "/hot")
    public CommonResult getHotCompanies(@RequestParam("cityId") int cityId) {
        return ResultGenerator.genSuccessfulResult(companyService.queryHotCompaniesByCriteria(cityId));
    }

    /*
     *  查询所有融资阶段
     *
     */
    @ApiOperation(value = "查询所有融资阶段",notes = "查询所有融资阶段")
    @GetMapping(value = "/financingStage/all")
    public CommonResult getAllFinancingStages() {
        return ResultGenerator.genSuccessfulResult(financingStageService.queryAllFinancingStages());
    }

    /*
     *  查询所有公司规模
     */
    @ApiOperation(value = "查询所有公司规模",notes = "查询所有公司规模")
    @RequestMapping(value = "/scale/all")
    public CommonResult getCompanyScales() {
        return ResultGenerator.genSuccessfulResult(companyScaleService.queryAllCompanyScales());
    }


    /*
    * 查询所有产业
    * */
    @ApiOperation(value = "查询所有产业",notes = "查询所有产业")
    @GetMapping(value = "/industry/all")
    public CommonResult getAllIndustries() {
        return ResultGenerator.genSuccessfulResult(industryService.queryAllIndustries());
    }


    /*
    * 更新公司信息
    * */
    @ApiOperation(value = "更新公司信息",notes = "更新公司信息")
    @PutMapping(value = "/update")
    public CommonResult updateCompany(@RequestBody Company company)  {
        return ResultGenerator.genEditSuccessfulResult(companyService.modifyCompany(company));
    }


}
