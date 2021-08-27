package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.UserTemperature;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Mapper
public interface MainMapper {
    List<UserTemperature> userTempDayAvg(UserTemperature userTemperature);
}
