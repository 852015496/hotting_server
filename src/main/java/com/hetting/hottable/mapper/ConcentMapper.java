package com.hetting.hottable.mapper;

import com.alibaba.fastjson.JSONObject;
import com.hetting.hottable.entity.Concent;
import com.hetting.hottable.entity.ConcentMessage;
import com.hetting.hottable.entity.ConcentMessageVO;
import com.hetting.hottable.entity.UserVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ConcentMapper {

    int deleteByPrimaryKey(String concentCode);

    int insert(Concent record);

    int insertSelective(Concent record);

    Concent selectByPrimaryKey(Integer concentId);

    int updateByPrimaryKeySelective(Concent record);

    int updateByPrimaryKey(Concent record);

    List<Concent> listConcent(Concent concent);

    Integer deleteAllConcent(Map<String, List<String>> id);

    List<Concent> concentListAll(Concent concent);

    Integer deleteByConcentId(Integer concentId);

    List<Concent> concentTerm(Concent concent);

    List<String> concentNum();

    List<String> faultNumber();

    List<Concent> allNumberCount(Concent concent);

    Concent valveHotFault();

//    List<Concent> concentNormalAndFault(Concent concent);

    Concent concentNormalAndFault();

    Integer updateByAddress(Concent concent);

    Concent concentCodeInfoList(String concentCode);

    // 根据上报集中器Code 查询集中器是否存在
    List<ConcentMessage> findList2(ConcentMessageVO message);

    Object findConcentCode(String addr);

    Object findHistory(String addr);

    Object finMetaData(String addr);
}