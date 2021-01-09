package org.lieying.service;

import org.lieying.bean.Credential;

public interface CredentialService {
    Boolean addCredential(Credential credential);
    Boolean modifyCredential(Credential credential);
}
