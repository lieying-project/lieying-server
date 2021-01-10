package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Position;
import org.lieying.bean.PositionBrowse;

import java.util.Date;
import java.util.List;

public interface PositionBrowseMapper {
    int insertPositionBrowse(@Param("position_browse_created_time")Date createdTime,
                             @Param("job_hunter_id")int jobHunterId,
                             @Param("position_id")int positionId);
    List<PositionBrowse> selectPositionBrowsesByJobHunterId(int id);
    List<PositionBrowse> selectDetailPositionBrowsesByJobHunterId(int id);


    List<PositionBrowse> selectAllPositionBrowses();
}
