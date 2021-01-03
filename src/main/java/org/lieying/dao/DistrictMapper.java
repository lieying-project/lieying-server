package org.lieying.dao;

import cn.pomit.jpamapper.core.mapper.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lieying.bean.District;
@Mapper
public interface DistrictMapper extends CrudMapper<District,Integer> {
}
