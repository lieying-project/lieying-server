package org.lieying.service.impl;

import org.lieying.bean.SocialHomepage;
import org.lieying.dao.SocialHomepageMapper;
import org.lieying.service.SocialHomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialHomepageServiceImpl implements SocialHomepageService {
    @Autowired
    private SocialHomepageMapper socialHomepageMapper;
    @Override
    public Boolean addSocialhomepage(SocialHomepage socialHomepage) {
        try {
            Integer resumeId=null;
            if (socialHomepage.getResume()!=null){
                resumeId=socialHomepage.getResume().getId();
            }
            return socialHomepageMapper.insertSocialHomepage(socialHomepage.getUrl(),socialHomepage.getSign(),
                    socialHomepage.getCreatedTime(),socialHomepage.getUpdatedTime(),resumeId)==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean modifySocialhomepage(SocialHomepage socialHomepage) {
        try {
            Integer resumeId=null;
            if (socialHomepage.getResume()!=null){
                resumeId=socialHomepage.getResume().getId();
            }
            return socialHomepageMapper.updateSocialHomepage(socialHomepage.getId(), socialHomepage.getUrl(),socialHomepage.getSign(),
                    socialHomepage.getCreatedTime(),socialHomepage.getUpdatedTime(),resumeId)==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
