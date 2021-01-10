package org.lieying.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.assertj.core.util.Lists;
import org.lieying.bean.Position;
import org.lieying.bean.PositionBrowse;
import org.lieying.bean.RelateDTO;
import org.lieying.dao.PositionBrowseMapper;
import org.lieying.dao.PositionMapper;
import org.lieying.service.PositionService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionBrowseMapper positionBrowseMapper;
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
    @Override
    public List<Position> recomendPosition(int jobHunterId) {
        List<PositionBrowse> positionBrowses=positionBrowseMapper.selectAllPositionBrowses();
        System.out.println(positionBrowses.size());
        List<RelateDTO> relateDTOS=new ArrayList<>();
        for (PositionBrowse positionBrowse:positionBrowses){
            RelateDTO relateDTO=new RelateDTO();
            relateDTO.setUseId(positionBrowse.getJobHunter().getId());
            relateDTO.setModuleId(positionBrowse.getPosition().getId());
            Random random=new Random();
            relateDTO.setIndex(1);
            relateDTOS.add(relateDTO);
        }
        List<Integer> positionIds= recommend(jobHunterId,relateDTOS);

        List<Position> positions=new ArrayList<>();
        for (Integer positionId:positionIds){
            Position position=positionMapper.selectDetailPositionById(positionId);
            positions.add(position);
        }
        return  positions;
    }


    public List<Integer> recommend(Integer userId, List<RelateDTO> list) {
        //找到最近邻用户id
        Map<Double, Integer> distances = computeNearestNeighbor(userId, list);
        Integer nearest = distances.values().iterator().next();

        Map<Integer, List<RelateDTO>>  userMap=list.stream().collect(Collectors.groupingBy(RelateDTO::getUseId));

        //最近邻用户看过职位列表
        List<Integer>  neighborItemList = userMap.get(nearest).stream().map(e->e.getModuleId()).collect(Collectors.toList());
        //指定用户看过职位列表
        List<Integer>  userItemList  = userMap.get(userId).stream().map(e->e.getModuleId()).collect(Collectors.toList());;

        //找到最近邻看过，但是该用户没看过的职位，计算推荐，放入推荐列表
        List<Integer> recommendList = new ArrayList<>();
        for (Integer item : neighborItemList) {
            if (!userItemList.contains(item)) {
                recommendList.add(item);
            }
        }
        Collections.sort(recommendList);
        return recommendList;
    }


    /**
     * 在给定userId的情况下，计算其他用户和它的相关系数并排序
     * @param userId
     * @param list
     * @return
     */
    private Map<Double, Integer> computeNearestNeighbor(Integer userId, List<RelateDTO> list) {
        System.out.println(list.size());
        Map<Integer, List<RelateDTO>>  userMap=list.stream().collect(Collectors.groupingBy(RelateDTO::getUseId));


        Map<Double, Integer> distances = new TreeMap<>();
        userMap.forEach((k,v)->{

            if(k!=userId){

                double distance = pearson_dis(v,userMap.get(userId));
                distances.put(distance, k);
            }
        });

        return distances;
    }


    /**
     * 计算两个序列间的相关系数
     *
     * @param xList
     * @param yList
     * @return
     */
    private double pearson_dis(List<RelateDTO> xList, List<RelateDTO> yList) {
        List<Integer> xs= Lists.newArrayList();
        List<Integer> ys= Lists.newArrayList();
        xList.forEach(x->{
            yList.forEach(y->{
                if(x.getModuleId()==y.getModuleId()){
                    xs.add(x.getIndex());
                    ys.add(y.getIndex());
                }
            });
        });
        return getRelate(xs,ys);
    }

    /**
     * 方法描述: 皮尔森（pearson）相关系数计算
     *
     * @param xs
     * @param ys
     * @Return {@link Double}
     * @throws

     */
    public static Double getRelate(List<Integer> xs, List<Integer>  ys){
        int n=xs.size();
        double Ex= xs.stream().mapToDouble(x->x).sum();
        double Ey=ys.stream().mapToDouble(y->y).sum();
        double Ex2=xs.stream().mapToDouble(x->Math.pow(x,2)).sum();
        double Ey2=ys.stream().mapToDouble(y->Math.pow(y,2)).sum();
        double Exy= IntStream.range(0,n).mapToDouble(i->xs.get(i)*ys.get(i)).sum();
        double numerator=Exy-Ex*Ey/n;
        double denominator=Math.sqrt((Ex2-Math.pow(Ex,2)/n)*(Ey2-Math.pow(Ey,2)/n));
        if (denominator==0) return 0.0;
        return numerator/denominator;
    }

}
