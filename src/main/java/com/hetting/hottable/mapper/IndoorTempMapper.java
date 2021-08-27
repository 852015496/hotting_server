package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.IndoorTemp;

import java.util.List;

public interface IndoorTempMapper {

    List<IndoorTemp> buildingList(String plotAddress);

    List<IndoorTemp> cellList(String userBuilding);

    List<IndoorTemp> doorTempData(String userDoorNum);
}
