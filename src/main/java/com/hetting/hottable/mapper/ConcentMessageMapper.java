package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.*;
import com.hetting.hottable.export.Entity.ExportConcentUserMessage;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ConcentMessageMapper {

    int insert(ConcentMessage record);

    int insertSelective(ConcentMessage record);

    ConcentMessage selectByPrimaryKey(Long concentmId);

    int updateByPrimaryKeySelective(ConcentMessage record);

    int updateByPrimaryKey(ConcentMessage record);

    List<ConcentMessageVO> concentUserList(ConcentMessageVO concentMessageVO);

    Integer deleteAll(Map<String, List<String>> id);

    int select(String housing,String concentCode);

    List<ConcentMessageVO> exportUserMessage();

    List<ConcentMessage> findList(ConcentMessageVO qct);

    static List<FacilityAllMessage> findList3(FacilityAllMessage qr) {
        return null;
    }

    List<String> selectNewHot(String yibiaodizhidm);

    Integer updateRunStatus(FacilityAllMessage amm);

    Integer saveConcentMessage(Concent concentMessage);
}