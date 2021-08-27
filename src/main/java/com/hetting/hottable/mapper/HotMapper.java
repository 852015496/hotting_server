package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HotMapper {

    int deleteByPrimaryKey(Integer hotId);

    int insert(Hot record);

    int insertSelective(Hot record);

    Hot selectByPrimaryKey(Integer hotId);

    int updateByPrimaryKeySelective(Hot record);

    int updateByPrimaryKey(Hot record);

    void deleteByHotAddress();

    void deleteById(Integer userId);

    void deleteByConcentId(Integer concentId);

    List<Alarm> unfinishedFacility(Alarm alarm);

    String selectByUserId(List ids);

    int updateByImportData(Hot hot);

    Hot hotAndContrast(DataContrastVO dataContrastVO);

    Hot hotAndContrastTwo(DataContrastVO dataContrastVO);

    String findCjdm(String id);

    Integer insertSelective(User us);

    List<HotAndValve> findByJzqCode(String address);

    List<Hot> selectHotIdAndUserId();

    Hot selectAllMessage();

    void insertMqttHot(Hot h);
}