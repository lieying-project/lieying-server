package org.lieying.service.impl;

import org.assertj.core.util.Lists;
import org.lieying.bean.JobHunter;
import org.lieying.bean.Position;
import org.lieying.bean.PositionBrowse;
import org.lieying.bean.RelateDTO;
import org.lieying.dao.PositionBrowseMapper;
import org.lieying.dao.PositionMapper;
import org.lieying.service.PositionBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PositionBrowseServiceImpl implements PositionBrowseService {


    @Autowired
    private PositionBrowseMapper positionBrowseMapper;
    @Override
    public Boolean addPositionBrowse(PositionBrowse positionBrowse) {
        Position position=positionBrowse.getPosition();
        JobHunter jobHunter=positionBrowse.getJobHunter();
        Date createdTime=positionBrowse.getCreatedTime();
        if (position==null||jobHunter==null){
            return null;
        }
        return positionBrowseMapper.insertPositionBrowse(createdTime,jobHunter.getId(),position.getId())==1;
    }



}
