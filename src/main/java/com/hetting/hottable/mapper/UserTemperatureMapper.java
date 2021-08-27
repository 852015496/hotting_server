package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.UserTemperature;
import com.hetting.hottable.entity.Valve;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserTemperatureMapper {


    List<UserTemperature> userTemperatureList(UserTemperature userTemperature);

    List<UserTemperature> eighteenUnderUserMap(UserTemperature userTemperature);

    List<UserTemperature> twentyFourUnderUserMap(UserTemperature userTemperature);

    List<UserTemperature> indoorTempAvg(UserTemperature userTemperature);

    List<UserTemperature> indoorTempValveData(UserTemperature userTemperature);

    List<UserTemperature> allUserAvgTemp(UserTemperature userTemperature);

    List<UserTemperature> userTempDayAvg(UserTemperature userTemperature);

    List<UserTemperature> userCount(UserTemperature userTemperature);

    List<UserTemperature> toAndForTemp(UserTemperature userTemperature);

    String selectConcentCodeByWorkModal(Valve valve);

    List<UserTemperature> indoorTemp();
}
