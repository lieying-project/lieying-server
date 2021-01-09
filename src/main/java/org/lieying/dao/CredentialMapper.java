package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Credential;

import java.util.List;

public interface CredentialMapper {

    List<Credential> selectCredentialsByResumeId(int resumeId);
    int insertCredential(@Param("credential_name") String name,
                         @Param("credential_photo") String photo, @Param("resume_id") Integer resumeId );
    int updateCredential(@Param("credential_id")Integer credentialId,
                         @Param("credential_name") String name,
                         @Param("credential_photo") String photo, @Param("resume_id") Integer resumeId);
}
