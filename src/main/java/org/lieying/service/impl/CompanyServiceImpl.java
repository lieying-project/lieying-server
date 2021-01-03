package org.lieying.service.impl;
import org.lieying.bean.Company;
import org.lieying.dao.CompanyMapper;
import org.lieying.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
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
        return companyMapper.selectCompaniesByCriteria(cityId,industryId,financingStageId,companyScaleId);
    }

    @Override
    public List<Company> queryHotCompaniesByCriteria(Integer cityId) {

        return companyMapper.selectHotCompaniesByCriteria(cityId);
    }
}
