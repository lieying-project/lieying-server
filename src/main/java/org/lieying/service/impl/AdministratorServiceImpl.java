package org.lieying.service.impl;

import org.lieying.bean.Administrator;
import org.lieying.dao.AdministratorMapper;
import org.lieying.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Cacheable(value = "cache1")
    @Transactional(readOnly = true)
    @Override
    public Administrator queryAdministratorByUsernameAndPassword(String username, String password) {
        return administratorMapper.selectAdministratorByUsernameAndPassword(username,password);
    }

    @Override
    public Administrator queryDetailAdministratorById(int administratorId) {
        return administratorMapper.selectDetailAdministratorById(administratorId);
    }
}
