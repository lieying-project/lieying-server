package org.lieying.service.impl;

import org.lieying.bean.FinancingStage;
import org.lieying.dao.FinancingStageMapper;
import org.lieying.service.FinancingStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FinancingStageServiceImpl implements FinancingStageService {
    @Autowired
    private FinancingStageMapper financingStageMapper;
    @Override
    public List<FinancingStage> queryAllFinancingStages() {
        return financingStageMapper.selectAllFinancingStages();
    }
}
