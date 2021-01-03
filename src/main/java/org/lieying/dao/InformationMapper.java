package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Information;

import java.util.Date;
import java.util.List;

public interface InformationMapper {

    List<Information> selectAllInformations();

    Information selectDetailInformationById(int id);

    int insertInformation(@Param("information_title") String title,
                          @Param("information_content") String content,
                          @Param("information_created_time") Date createdTime,
                          @Param("information_type") String type,
                          @Param("administrator_id") Integer administratorId);


}
