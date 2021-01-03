package org.lieying.service.impl;

import org.lieying.bean.Resource;
import org.lieying.dao.ResourceMapper;
import org.lieying.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Resource queryDetailResourceById(int resourceId) {
        return resourceMapper.selectDetailResourceById(resourceId);
    }
}
