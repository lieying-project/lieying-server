package org.lieying.service.impl;

import org.lieying.dao.CredentialMapper;
import org.lieying.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    private CredentialMapper credentialMapper;


    @Override
    public Boolean addCredential(String name, String photo, int resumeId) {
        return credentialMapper.insertCredential(name,photo,resumeId)==1;
    }
}
