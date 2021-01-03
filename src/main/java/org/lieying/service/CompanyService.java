package org.lieying.service;

import org.lieying.bean.Company;

import java.util.List;

public interface CompanyService {
     Company queryCompanyById(int id);
     List<Company> queryCompaniesByCriteria( Integer cityId,
                                                   Integer industryId,
                                                   Integer financingStageId,
                                                  Integer companyScaleId);
     List<Company> queryHotCompaniesByCriteria(Integer cityId);
}
