package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Company;

import java.util.List;

public interface CompanyMapper {

    Company selectCompanyById(int id);
    List<Company> selectCompaniesByCriteria(@Param("city_id") Integer cityId,
                                                   @Param("industry_id")Integer industryId,
                                                   @Param("financing_stage_id")Integer financingStageId,
                                                   @Param("company_scale_id")Integer companyScaleId);
    List<Company> selectHotCompaniesByCriteria(@Param("city_id")int cityId);
}
