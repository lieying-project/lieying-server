package org.lieying.dao;

import org.lieying.bean.Industry;

import java.util.List;

public interface IndustryMapper {
    Industry selectIndustryById(int id);
    List<Industry> selectAllIndustries();
}
