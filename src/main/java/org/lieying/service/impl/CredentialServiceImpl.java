package org.lieying.service.impl;

import org.lieying.bean.Credential;
import org.lieying.dao.CredentialMapper;
import org.lieying.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    private CredentialMapper credentialMapper;


    @Override
    public Boolean addCredential(Credential credential) {
        try {
            return credentialMapper.insertCredential(credential.getName(),credential.getPhoto(),credential.getResume().getId())==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean modifyCredential(Credential credential) {
        try {
            return credentialMapper.updateCredential(credential.getId(),credential.getName(),credential.getPhoto(),credential.getResume().getId())==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
