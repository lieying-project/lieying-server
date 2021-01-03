package org.lieying.service.impl;

import org.lieying.bean.PositionCategory;
import org.lieying.dao.PositionCategoryMapper;
import org.lieying.service.PositionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("positionCategoryService")
public class PositionCategoryServiceImpl implements PositionCategoryService {
    @Autowired
    private PositionCategoryMapper positionCategoryMapper;

//    @Cacheable(value = "cache1")
    @Transactional(readOnly = true)
    @Override
    public List<PositionCategory> queryAllPositionCategories() {
        return positionCategoryMapper.selectAllPositionCategories();
    }
//    @Cacheable(value = "cache1")
    @Transactional(readOnly = true)
    @Override
    public PositionCategory queryPositionCategoryById(int id) {
        return positionCategoryMapper.selectPositionCategoryById(id);
    }
}
