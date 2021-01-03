package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import org.lieying.bean.*;
import org.lieying.service.CompanyScaleService;
import org.lieying.service.CompanyService;
import org.lieying.service.FinancingStageService;
import org.lieying.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin
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
    @RequestMapping(value="/{id}",produces = "text/plain;charset=UTF-8")
    public String getCompanyById(@PathVariable("id") int id) {
        return JSON.toJSONString(companyService.queryCompanyById(id));
    }
    /*
     * 多条件查询公司信息
     * @param   cityId             城市id
     * @param   industryId         公司行业id
     * @param   financingStageId   融资阶段id
     * @param   companyScaleId     公司规模id
     * */
    @RequestMapping(value = "",produces = "text/plain;charset=UTF-8")
    public String getCompanyByCriteria(@RequestParam(value = "cityId", required = false) Integer cityId,
                                               @RequestParam(value = "industryId", required = false) Integer industryId,
                                               @RequestParam(value = "financingStageId", required = false) Integer financingStageId,
                                               @RequestParam(value = "companyScaleId", required = false) Integer companyScaleId) {

        List<Company> companies=companyService.queryCompaniesByCriteria(cityId, industryId, financingStageId, companyScaleId);
        System.out.println(cityId+" "+industryId+" "+financingStageId+" "+companyScaleId);
        System.out.println(companies.size());
        return JSON.toJSONString(companies);
    }

    /*
     *  查询热门公司
     *  @param  cityId 城市id
     */
    @RequestMapping(value="/hot", produces = "text/plain;charset=UTF-8")
    public String getHotCompanies(@RequestParam("cityId") int cityId){
        return JSON.toJSONString(companyService.queryHotCompaniesByCriteria(cityId));
    }

    /*
    *  查询所有融资阶段
    *
    */
    @RequestMapping(value="/financingStage/all", produces = "text/plain;charset=UTF-8")
    public String getAllFinancingStages(){
        return JSON.toJSONString(financingStageService.queryAllFinancingStages());
    }

    /*
    *  查询所有公司规模
    */
    @RequestMapping(value="/scale/all", produces = "text/plain;charset=UTF-8")
    public String getCompanyScales(){
        return  JSON.toJSONString(companyScaleService.queryAllCompanyScales());
    }



    @RequestMapping(value="/industry/all",produces = "text/plain;charset=UTF-8")
    public String getAllIndustries(){
        return JSON.toJSONString(industryService.queryAllIndustries());
    }

}
