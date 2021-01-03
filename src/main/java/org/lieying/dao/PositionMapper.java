package org.lieying.dao;

import cn.pomit.jpamapper.core.mapper.CrudMapper;
import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Position;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PositionMapper{
     Position selectDetailPositionById(int id);
     List<Position> selectPositionsByCriteria(@Param("keyword") String keyword,
                                                    @Param("city_id")Integer cityId,
                                                    @Param("position_category_id")Integer positionCategoryId,
                                                    @Param("industry_id") Integer industryId,
                                                    @Param("position_education")String positionEducation,
                                                    @Param("position_salary")String positionSalary,
                                                    @Param("position_experience") String positionExperience,
                                                    @Param("financing_stage_id") Integer financingStageId,
                                                    @Param("position_publish_time") String positionPublishTime);
     int insertPosition(@Param("position") Position position,@Param("recruiterId") int recruiterId);

     List<Position> selectHotPositionsByCriteria(@Param(value = "city_id")int cityId,@Param("position_category_id")int positionCategoryId);
     List<Position> selectBrowsedPositionsByJobHunterId(int jobHunterId);
}
