package org.lieying.service;

import org.lieying.bean.Industry;

import java.util.List;

public interface IndustryService {
    Industry queryIndustryById(int id);
    List<Industry> queryAllIndustries();
}
