package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Company;

import java.util.Date;
import java.util.List;

public interface CompanyMapper {

    Company selectCompanyById(int id);

    List<Company> selectCompaniesByCriteria(@Param("city_id") Integer cityId,
                                            @Param("industry_id") Integer industryId,
                                            @Param("financing_stage_id") Integer financingStageId,
                                            @Param("company_scale_id") Integer companyScaleId);

    List<Company> selectHotCompaniesByCriteria(@Param("city_id") int cityId);

    int updateCompany(
            @Param("company_id") Integer companyId,
            @Param("company_name") String companyName,
            @Param("company_address") String companyAddress,
            @Param("company_phone") String companyPhone,
            @Param("company_intro") String companyIntro,
            @Param("company_sign") String companySign,
            @Param("company_culture") String companyCulture,
            @Param("company_license") String companyLicense,
            @Param("company_representative") String companyRepresentative,
            @Param("company_established") Date companyEstablished,
            @Param("company_register_capital") String companyRegisterCapital,
            @Param("company_business_scope") String companyBusinessScope,
            @Param("company_employee_welfare") String companyEmployeeWelfare,
            @Param("company_work_time") Date companyWorkTime,
            @Param("city_id") Integer cityId,
            @Param("industry_id") Integer industryId,
            @Param("company_scale_id") Integer companyScaleId,
            @Param("financing_stage_id") Integer financingStageId);
}
