package org.lieying.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lieying.bean.Position;
import org.lieying.dao.PositionMapper;
import org.lieying.service.PositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("positionService")
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Transactional(readOnly = true)
    //@Cacheable(value = "cache1")
    @Override
    public Position queryDetailPositionById(int id) {
        return positionMapper.selectDetailPositionById(id);
    }

    @Transactional(readOnly = true)
    // @Cacheable(value = "cache1")
    @Override
    public PageInfo<Position> queryPositionsByCriteria(String keyword,
                                                       Integer cityId,
                                                       Integer positionCategoryId,
                                                       Integer industryId,
                                                       String positionEducation,
                                                       String positionSalary,
                                                       String positionExperience,
                                                       Integer financingStageId,
                                                       String positionPublishTime,
                                                       Integer recruiterId,
                                                       Integer page,
                                                       Integer pageSize) {
        if (pageSize==null){
            pageSize = 2;
        }

        System.out.println("page:" + page + " pageSize:" + pageSize);
        if (page == null) {
            page = 1;
        }
        if (keyword == null) {
            keyword = "";
        }
        PageHelper.startPage(page, pageSize);
        List<Position> positions = positionMapper
                .selectPositionsByCriteria(
                        keyword,
                        cityId,
                        positionCategoryId,
                        industryId,
                        positionEducation,
                        positionSalary,
                        positionExperience,
                        financingStageId,
                        positionPublishTime,
                        recruiterId);
        PageInfo<Position> pageInfo = new PageInfo<>(positions);
        return pageInfo;
    }


    @Override
    public Boolean addPosition(Position position) {
        Integer positionCategoryId=null;
        Integer recruiterId=null;
        if (position.getPositionCategory()!=null){
            positionCategoryId=position.getPositionCategory().getId();
        }
        if (position.getRecruiter()!=null){
            recruiterId=position.getRecruiter().getId();
        }
        try {
            return positionMapper.insertPosition(position.getName(),
                    position.getSalary(),
                    position.getAddress(),
                    position.getEducation(),
                    position.getExperience(),
                    position.getDetail(),
                    position.getPublishTime(),
                    recruiterId,
                    positionCategoryId)==1;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }

    @Override
    public Boolean updatePosition(Position position) {
        Integer recruiterId=null;
        if (position.getRecruiter()!=null){
            recruiterId=position.getRecruiter().getId();
        }

        return positionMapper.updatePosition(position.getId(),
                position.getName(),
                position.getSalary(),
                position.getAddress(),
                position.getEducation(),
                position.getExperience(),
                position.getDetail(),
                position.getPublishTime(),
                recruiterId)==1;
    }

    @Override
    public Boolean removePosition(int id) {
        return positionMapper.deletePosition(id)==1;
    }

    @Override
    public List<Position> queryHotPositionsByCriteria(int cityId, int positionCategoryId) {
        return positionMapper.selectHotPositionsByCriteria(cityId, positionCategoryId);
    }

    @Override
    public List<Position> queryBrowsedPositionsByJobHunterId(int jobHunterId) {
        return positionMapper.selectBrowsedPositionsByJobHunterId(jobHunterId);
    }
}
