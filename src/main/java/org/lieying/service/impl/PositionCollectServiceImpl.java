package org.lieying.service.impl;

import org.lieying.bean.JobHunter;
import org.lieying.bean.Position;
import org.lieying.bean.PositionCollect;
import org.lieying.dao.PositionCollectMapper;
import org.lieying.service.PositionCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionCollectServiceImpl implements PositionCollectService {

    @Autowired
    private PositionCollectMapper positionCollectMapper;
    @Override
    public Boolean addPositionCollect(PositionCollect positionCollect) {
        Position position=positionCollect.getPosition();
        JobHunter jobHunter=positionCollect.getJobHunter();
        if (position==null||jobHunter==null){
            return null;
        }
        System.out.println(position);
        System.out.println(jobHunter);
        System.out.println(positionCollect.getCreatedTime());
        try{
            return positionCollectMapper.insertPositionCollect(positionCollect.getCreatedTime(),
                    position.getId(),jobHunter.getId())==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean removePositionCollect(int id) {
        try {
            return positionCollectMapper.deletePositionCollect(id)==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
