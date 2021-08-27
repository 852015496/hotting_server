package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.Concent;
import com.hetting.hottable.entity.DataContrastVO;
import com.hetting.hottable.entity.User;
import com.hetting.hottable.entity.UserTemperature;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    void deleteByUserCode();

    Integer deleteById(Integer userId);

    void deleteByConcentId(Integer concentId);

    List<UserTemperature> userSum(User user);

    List<String> userNumArea();

    Integer updateByAddress(Concent concent);

    int updateByImportData(User user);

    List<DataContrastVO> selectUserBuilding();

    List<DataContrastVO> selectUserDoorNum();

    static User get(Integer userId) {
        return null;
    }

    List<User> selectUserIdAndConcentId();
}