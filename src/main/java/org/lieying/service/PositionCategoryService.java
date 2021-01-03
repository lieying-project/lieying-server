package org.lieying.service;

import org.lieying.bean.PositionCategory;

import java.util.List;

public interface PositionCategoryService {
     List<PositionCategory> queryAllPositionCategories();
     PositionCategory queryPositionCategoryById(int id);
}
