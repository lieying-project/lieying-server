package org.lieying.dao;

import cn.pomit.jpamapper.core.mapper.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lieying.bean.Province;
@Mapper
public interface ProvinceMapper extends CrudMapper<Province,Integer> {
}
