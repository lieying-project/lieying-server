package org.lieying.service.impl;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Company;
import org.lieying.dao.CompanyMapper;
import org.lieying.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    //    @Cacheable(value = "cache1")
    @Override
    public Company queryCompanyById(int id) {
        return companyMapper.selectCompanyById(id);
    }

    @Override
    public List<Company> queryCompaniesByCriteria(Integer cityId, Integer industryId, Integer financingStageId, Integer companyScaleId) {
        return companyMapper.selectCompaniesByCriteria(cityId, industryId, financingStageId, companyScaleId);
    }

    @Override
    public List<Company> queryHotCompaniesByCriteria(Integer cityId) {

        return companyMapper.selectHotCompaniesByCriteria(cityId);
    }

    @Override
    public Boolean modifyCompany(Company company) {
        try {
            return companyMapper.updateCompany(company.getId(),
                    company.getName(), company.getAddress(),
                    company.getPhone(),
                    company.getIntro(), company.getSign(),
                    company.getCulture(), company.getLicense(), company.getRepresentative(),
                    company.getEstablished(), company.getRegisterCapital(), company.getBusinessScope(),
                    company.getEmployeeWelfare(), company.getWorkTime(),
                    company.getCity().getId(),
                    company.getIndustry().getId(),
                    company.getCompanyScale().getId(), company.getFinancingStage().getId()) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
}
