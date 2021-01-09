package org.lieying.service;

import com.github.pagehelper.PageInfo;
import org.lieying.bean.Position;


import java.util.List;

public interface PositionService {

    Position queryDetailPositionById(int id);

    PageInfo<Position> queryPositionsByCriteria(String keyword,
                                             Integer cityId,
                                             Integer positionCategoryId,
                                             Integer industryId,
                                             String positionEducation,
                                             String positionSalary,
                                             String positionExperience,
                                             Integer financingStageId,
                                             String positionPublishTime,
                                                Integer recruiterId,
                                                Integer page,Integer pageSize
                                                );
    Boolean addPosition(Position position);
    Boolean updatePosition(Position position);
    Boolean removePosition(int id);
    List<Position> queryHotPositionsByCriteria(int cityId,int positionCategoryId);
    List<Position> queryBrowsedPositionsByJobHunterId(int jobHunterId);
}
