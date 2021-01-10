package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import javafx.geometry.Pos;
import org.lieying.bean.*;
import org.lieying.service.PositionBrowseService;
import org.lieying.service.PositionCategoryService;
import org.lieying.service.PositionCollectService;
import org.lieying.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
//@CrossOrigin
@RestController
@RequestMapping(value = "/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private PositionCategoryService positionCategoryService;
    @Autowired
    private PositionCollectService positionCollectService;
    @Autowired
    private PositionBrowseService positionBrowseService;

    /*
     * 职位详情
     * @param  positionId   职位id
     */
    @RequestMapping(value = "/{positionId}", produces = "text/plain;charset=UTF-8")
    public String getPositionById(@PathVariable int positionId,HttpServletRequest request) {
        //long before = System.currentTimeMillis();
        Position position = positionService.queryDetailPositionById(positionId);
        //long after = System.currentTimeMillis();
        //System.out.println(after - before);



        return JSON.toJSONString(position);
    }

    /*
     *  多条件搜索职位 每个条件非必选
     *  @param   keyword              职位关键字
     *  @param   cityId               城市id
     *  @param   positionCategoryId   职位分类id
     *  @param   industryId           行业id
     *  @param   positionEducation    学历
     *  @param   positionSalary       薪资
     *  @param   positionExperience   经验
     *  @param   financingStageId     融资阶段id
     *  @param   positionPublishTime  职位发布时间
     */

    @RequestMapping(value = "", produces = "text/plain;charset=UTF-8")
    public String getPositionsByCriteria(@RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "cityId", required = false) Integer cityId,
                                         @RequestParam(value = "positionCategoryId", required = false) Integer positionCategoryId,
                                         @RequestParam(value = "industryId", required = false) Integer industryId,
                                         @RequestParam(value = "positionEducation", required = false) String positionEducation,
                                         @RequestParam(value = "positionSalary", required = false) String positionSalary,
                                         @RequestParam(value = "positionExperience", required = false) String positionExperience,
                                         @RequestParam(value = "financingStageId", required = false) Integer financingStageId,
                                         @RequestParam(value = "positionPublishTime", required = false) String positionPublishTime,
                                         @RequestParam(value = "recruiterId", required = false) Integer recruiterId,
                                         @RequestParam(value = "page", required = false) Integer page,
                                         @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                         HttpServletRequest request) {
//        System.out.println("keyword:" + keyword + " cityId:" + cityId + " positionCategoryId:" + positionCategoryId + " industryId:" + industryId +
//                " financingStageId:" + financingStageId);
        System.out.println(request.getRequestURL());

        return JSON.toJSONString(positionService.queryPositionsByCriteria(
                keyword,
                cityId,
                positionCategoryId,
                industryId,
                positionEducation,
                positionSalary,
                positionExperience,
                financingStageId,
                positionPublishTime,recruiterId,page,pageSize));
    }

    /*
    *   添加职位
    *   @param   name      职位名称
    *   @param   salary    职位薪资
    *   @param   address   地址
    *   @param   education 学历
    *   @param   detail    详情
    *   @param   recruiterId 招聘者id
    * */
    @PostMapping(value = "/save",produces = "text/plain;charset=UTF-8")
    public String savePosition(@RequestBody Position position) {
        System.out.println(position);
        return JSON.toJSONString(positionService.addPosition(position));
    }


    /*更新职位
    * @param position 职位信息
    * */
    @PostMapping(value = "/update",produces = "text/plain;charset=UTF-8")
    public String updatePosition(@RequestBody Position position){
        return JSON.toJSONString(positionService.updatePosition(position));
    }
    /*
    * 删除职位
    * @param id 职位ID
    * */
    @RequestMapping(value = "/delete",produces = "text/plain;charset=UTF-8")
    public String deletePosition(@RequestParam("id") Integer id){
        System.out.println(id);
        return JSON.toJSONString(positionService.removePosition(id));

    }

    /*
    *   热门职位
    *   @param cityId             城市id
    *   @param positionCategoryId 职位类型id
    *
     */
    @RequestMapping(value = "/hot",produces = "text/plain;charset=UTF-8")
    public String hotPositions(@RequestParam("cityId") int cityId,@RequestParam("positionCategoryId")int positionCategoryId){
        //System.out.println("hot");
        return JSON.toJSONString( positionService.queryHotPositionsByCriteria(cityId,positionCategoryId));
    }
    /*
     *  查询所有职位类型
     *
     */
    @RequestMapping(value = "/category/all",produces = "text/plain;charset=UTF-8")
    public String getAllPositionCategories(){
        return JSON.toJSONString(positionCategoryService.queryAllPositionCategories());
    }

    /*
    *  收藏职位
    * */
    @PostMapping(value = "/collect/save",produces = "text/plain;charset=UTF-8")
    public String savePositionCollect(@RequestBody PositionCollect positionCollect){
        return JSON.toJSONString(positionCollectService.addPositionCollect(positionCollect));
    }
    /*
    *  删除职位收藏信息
    *
    * */
    @PostMapping(value = "/collect/delete/{id}",produces = "text/plain;charset=UTF-8")
        public String deletePositionCollect(@PathVariable int id){
        return JSON.toJSONString(positionCollectService.removePositionCollect(id));
    }

    @PostMapping(value = "/browse/save",produces = "text/plain;charset-UTF-8")
    public String savePositionBrowse(@RequestBody PositionBrowse positionBrowse){
        return JSON.toJSONString(positionBrowseService.addPositionBrowse(positionBrowse));
    }
    /*
     *  根据求职者id搜索浏览的职位信息
     *  @Param jobHunterId 求职者id
     * */
    @GetMapping(value = "/browse/{jobHunterId}",produces = "text/plain;charset=UTF-8")
    public String getBrowsedPositionsByJobHunterId(@PathVariable int jobHunterId){
        return JSON.toJSONString(positionService.queryBrowsedPositionsByJobHunterId(jobHunterId));
    }
    /*
     *  推荐职位
     *
     */
    @RequestMapping(value = "/recommend",produces = "text/plain;charset=UTF-8")
    public String recommendPosition(@RequestParam("jobHunterId") Integer jobHunterId){
        return JSON.toJSONString(positionService.recomendPosition(jobHunterId));
    }

}
