package org.lieying.service.impl;

import org.lieying.bean.Administrator;
import org.lieying.bean.Information;

import org.lieying.dao.InformationMapper;
import org.lieying.service.InformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;
    @Override
    public List<Information> queryAllInformations() {

        return informationMapper.selectAllInformations();
    }

    @Override
    public Information queryDetailInformationById(int id) {
        return informationMapper.selectDetailInformationById(id);
    }

    @Override
    public Boolean addInformation(Information information) {
        Administrator administrator=information.getAdministrator();
        if (administrator==null){
            return null;
        }
        return informationMapper.insertInformation(information.getTitle(),information.getContent(),information.getCreatedTime(),
                information.getType(),administrator.getId())==1;
    }
}
