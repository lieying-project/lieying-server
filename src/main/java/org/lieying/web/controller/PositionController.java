package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.geometry.Pos;
import org.lieying.bean.*;
import org.lieying.core.CommonResult;
import org.lieying.core.ResultGenerator;
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
@Api(value = "职位信息接口", tags = "职位信息")
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
    @ApiOperation(value = "职位详情", notes = "职位详情")
    @GetMapping(value = "/{positionId}")
    public CommonResult getPositionById(@PathVariable int positionId, HttpServletRequest request) {
        //long before = System.currentTimeMillis();
        Position position = positionService.queryDetailPositionById(positionId);
        //long after = System.currentTimeMillis();
        //System.out.println(after - before);
        return ResultGenerator.genSuccessfulResult(position);
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
    @ApiOperation(value = "多条件搜索职位", notes = "多条件搜索职位")
    @GetMapping(value = "")
    public CommonResult getPositionsByCriteria(@RequestParam(value = "keyword", required = false) String keyword,
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

        return ResultGenerator.genSuccessfulResult(positionService.queryPositionsByCriteria(
                keyword,
                cityId,
                positionCategoryId,
                industryId,
                positionEducation,
                positionSalary,
                positionExperience,
                financingStageId,
                positionPublishTime, recruiterId, page, pageSize));
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
    @ApiOperation(value = "添加职位", notes = "添加职位")
    @PostMapping(value = "/save")
    public CommonResult savePosition(@RequestBody Position position) {
        System.out.println(position);
        return ResultGenerator.genEditSuccessfulResult(positionService.addPosition(position));
    }


    /*更新职位
     * @param position 职位信息
     * */
    @ApiOperation(value = "更新职位", notes = "更新职位")
    @PutMapping(value = "/update")
    public CommonResult updatePosition(@RequestBody Position position) {
        return ResultGenerator.genEditSuccessfulResult(positionService.updatePosition(position));
    }

    /*
     * 删除职位
     * @param id 职位ID
     * */
    @ApiOperation(value = "删除职位")
    @DeleteMapping(value = "/delete", produces = "text/plain;charset=UTF-8")
    public CommonResult deletePosition(@RequestParam("id") Integer id) {
        System.out.println(id);
        return ResultGenerator.genDeleteSuccessfulResult(positionService.removePosition(id));

    }

    /*
     *   热门职位
     *   @param cityId             城市id
     *   @param positionCategoryId 职位类型id
     *
     */
    @ApiOperation(value = "热门职位", notes = "热门职位")
    @GetMapping(value = "/hot")
    public CommonResult hotPositions(@RequestParam("cityId") int cityId, @RequestParam("positionCategoryId") int positionCategoryId) {
        //System.out.println("hot");
        return  ResultGenerator.genSuccessfulResult(positionService.queryHotPositionsByCriteria(cityId, positionCategoryId));
    }

    /*
     *  查询所有职位类型
     *
     */
    @ApiOperation(value = "查询所有职位类型", notes = "查询所有职位类型")
    @GetMapping(value = "/category/all")
    public CommonResult getAllPositionCategories() {
        return ResultGenerator.genSuccessfulResult(positionCategoryService.queryAllPositionCategories());
    }

    /*
     *  收藏职位
     * */
    @ApiOperation(value = "收藏职位", notes = "收藏职位")
    @PostMapping(value = "/collect/save")
    public CommonResult savePositionCollect(@RequestBody PositionCollect positionCollect) {
        return ResultGenerator.genEditSuccessfulResult(positionCollectService.addPositionCollect(positionCollect));
    }

    /*
     *  删除职位收藏信息
     *
     * */
    @ApiOperation(value = "删除职位收藏信息", notes = "删除职位收藏信息")
    @DeleteMapping(value = "/collect/delete/{id}")
    public CommonResult deletePositionCollect(@PathVariable int id) {
        return ResultGenerator.genDeleteSuccessfulResult(positionCollectService.removePositionCollect(id));
    }

    /*
     * 保存职位浏览信息
     * */
    @ApiOperation(value = "保存职位浏览信息", notes = "保存职位浏览信息")
    @PostMapping(value = "/browse/save")
    public CommonResult savePositionBrowse(@RequestBody PositionBrowse positionBrowse) {
        return ResultGenerator.genEditSuccessfulResult(positionBrowseService.addPositionBrowse(positionBrowse));
    }

    /*
     *  根据求职者id搜索浏览的职位信息
     *  @Param jobHunterId 求职者id
     * */
    @ApiOperation(value = "根据求职者id搜索浏览的职位信息", notes = "根据求职者id搜索浏览的职位信息")
    @GetMapping(value = "/browse/{jobHunterId}")
    public CommonResult getBrowsedPositionsByJobHunterId(@PathVariable int jobHunterId) {
        return ResultGenerator.genSuccessfulResult(positionService.queryBrowsedPositionsByJobHunterId(jobHunterId));
    }

    /*
     *  推荐职位
     */
    @ApiOperation(value = "推荐职位", notes = "推荐职位")
    @GetMapping(value = "/recommend")
    public CommonResult recommendPosition(@RequestParam("jobHunterId") Integer jobHunterId) {
        return ResultGenerator.genSuccessfulResult(positionService.recomendPosition(jobHunterId));
    }

}
