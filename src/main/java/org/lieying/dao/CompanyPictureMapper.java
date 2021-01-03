package org.lieying.dao;

import org.lieying.bean.CompanyPicture;

import java.util.List;

public interface CompanyPictureMapper {
    List<CompanyPicture> selectCompanyPicturesByCompanyId(int companyId);
}
