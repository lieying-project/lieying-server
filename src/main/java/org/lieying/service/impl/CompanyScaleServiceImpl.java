package org.lieying.service.impl;

import org.lieying.bean.CompanyScale;
import org.lieying.dao.CompanyScaleMapper;
import org.lieying.service.CompanyScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyScaleServiceImpl implements CompanyScaleService {


    @Autowired
    private CompanyScaleMapper companyScaleMapper;
    @Override
    public List<CompanyScale> queryAllCompanyScales() {
        return companyScaleMapper.selectAllCompanyScales();
    }
}
