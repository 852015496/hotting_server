package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ValveMapper {
    int deleteByPrimaryKey(Integer valveId);

    int insert(Valve record);

    int insertSelective(Valve record);

    Valve selectByPrimaryKey(Integer valveId);

    int updateByPrimaryKeySelective(Valve record);

    int updateByPrimaryKey(Valve record);

    void deleteById(Integer userId);

    void deleteByConcentId(Integer concentId);

    Integer updateByValveWorkMode(Valve valve);

    Integer settingValveDefined(Valve valve);

    Integer settingIndoorTemp(Valve valve);

    List<Alarm> unfinishedFacility(Alarm alarm);

    List<String> setTemp();

    int updateByImportData(Valve valve);

    List<FacilityAllMessage> findList(FacilityAllMessage fm);

    Integer selectMaxPydzByJzqCode(String address);

    void updateBatchById(Concent concent);

    List<HotAndValve> findByJzqCode(String address);

    List<Valve> queryLastMessage(Valve valve);

    void saveValveLastMessage(Valve valve);

    void updateLastValveMessage(Valve valve);

    List<MeterData> selectValveMessage(String addr);

    List<Valve> selectValve();

    void insertMqttValve(Valve v);

    String avgIndoorTemp(String plotAddress);

    String avgInflowTemp(String poltAddress);

    String avgOutflowTemp(String poltAddress);

    String avgInflowTempMinusOutflowTemp(String plotAddress);

    List<String> buildingList(String plotAddress);
}