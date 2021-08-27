package mapperXml;

import entity.Hot;

public interface HotMapper {
    int deleteByPrimaryKey(Integer hotId);

    int insert(Hot record);

    int insertSelective(Hot record);

    Hot selectByPrimaryKey(Integer hotId);

    int updateByPrimaryKeySelective(Hot record);

    int updateByPrimaryKey(Hot record);
}