package org.lieying.service.impl;

import org.lieying.bean.Industry;
import org.lieying.dao.IndustryMapper;
import org.lieying.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    private IndustryMapper industryMapper;


    @Override
    public Industry queryIndustryById(int id) {
        return industryMapper.selectIndustryById(id);
    }

    @Override
    public List<Industry> queryAllIndustries() {
        return industryMapper.selectAllIndustries();
    }
}
