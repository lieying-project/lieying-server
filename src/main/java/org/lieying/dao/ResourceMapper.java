package org.lieying.dao;

import org.lieying.bean.Resource;

public interface ResourceMapper {
    Resource selectDetailResourceById(int resourceId);
}
