package com.hetting.hottable.controller;

import com.hetting.hottable.entity.Concent;
import com.hetting.hottable.entity.UserVO;
import com.hetting.hottable.server.impl.IConcentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/concent",tags = "集中器管理")
@RestController
@RequestMapping("/concent")
public class ConcentController {

    @Autowired
    private IConcentService concentService;

    /**
     * @Author ZhangWenTao
     * @Description //TODO 集中器列表展示
     * @Date 2020/8/31
     * @Param [concent]
     * @return java.util.List<com.hetting.hottable.entity.Concent>
     **/
    @PostMapping("/concentList")
    @ApiOperation(value = "获取集中器列表",httpMethod = "POST")
    public List<Concent> concentList(@RequestBody Concent concent) throws Exception{
        List<Concent> concentList = concentService.concentList(concent);
        return concentList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  获取集中器信息
     * @Date 2020/8/31
     * @Param [concent]
     * @return java.util.List<com.hetting.hottable.entity.Concent>
     **/
    @PostMapping("/concentTerm")
    @ApiOperation(value = "获取集中器列表",httpMethod = "POST")
    public List<Concent> concentTerm(@RequestBody Concent concent) throws Exception{
        List<Concent> concentTerm = concentService.concentTerm(concent);
        return concentTerm;
    }

    /*
     * @Author ZhangWenTao
     * @Description //TODO  增加集中器
     * @Date 2020/8/31
     * @Param [concent]
     * @return java.lang.Integer
     **/
    @ApiOperation(value = "添加集中器",httpMethod = "POST")
    @PostMapping("/addConcent")
    public Integer addConcent(@RequestBody Concent concent) throws Exception{
        return concentService.addConcent(concent);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  根据id删除集中器
     * @Date 2020/8/31
     * @Param [concent]
     * @return java.lang.Integer
     **/
    @PostMapping("/deleteConcent")
    @ApiOperation(value = "删除集中器",httpMethod = "POST")
    public Integer deleteConcent(@RequestBody Concent concent) throws Exception{
        if(null == concent.getConcentId()){
            return -1;
        }
        return concentService.deleteConcent(concent.getConcentId());
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 修改集中器信息
     * @Date 2020/8/31
     * @Param [concent]
     * @return java.lang.Integer
     **/
    @PostMapping("/updateConcent")
    @ApiOperation(value = "修改集中器",httpMethod = "POST")
    public Integer updateConcent(@RequestBody Concent concent) throws Exception{
        return concentService.updateConcent(concent);
    }

    @PostMapping("/updateConcentList")
    @ApiOperation(value = "回显数据",httpMethod = "POST")
    public Concent updateConcentList(Concent concent) throws Exception{
        Concent concentList = concentService.updateConcentList(concent);
        return concentList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  根据id批量删除集中器
     * @Date 2020/8/31
     * @Param [concent]
     * @return java.lang.Integer
     **/
    @ApiOperation(value = "集中器信息批量删除",httpMethod = "POST")
    @PostMapping("/deleteAllConcent")
    public Integer deleteAllConcent(@RequestBody Concent concent) throws Exception{
        //创建数组
        List list = new ArrayList<Integer>();
        //获取到的id用String类型接收并分割
        String [] strs = concent.getConcentCode().split(",");
        //循环取值
        for (String str:strs){
            //把值添加进去并转换成Integer类型
            list.add(Integer.parseInt(str));
        }
        return concentService.deleteAllConcent(list);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  配置集中器下用户的 热表 阀门
     * @Date 2020/8/31
     * @Param [userVO]
     * @return java.lang.Integer
     **/
    @ApiOperation(value = "仪表信息配置",httpMethod = "POST")
    @PostMapping("/addMaterMessage")
    public Integer addMaterMessage(@RequestBody UserVO userVO) throws Exception{
        return  concentService.addMaterMessage(userVO);
    }

}