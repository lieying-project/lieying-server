package org.lieying.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface PositionCollectMapper {

    int insertPositionCollect(@Param("position_collect_created_time")Date createdTime,
                              @Param("position_id") int positionId,
                              @Param("job_hunter_id")int jobHunterId);
    int deletePositionCollect(int id);
}
