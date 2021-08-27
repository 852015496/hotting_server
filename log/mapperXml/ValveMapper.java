package mapperXml;

import entity.Valve;

public interface ValveMapper {
    int deleteByPrimaryKey(Integer valveId);

    int insert(Valve record);

    int insertSelective(Valve record);

    Valve selectByPrimaryKey(Integer valveId);

    int updateByPrimaryKeySelective(Valve record);

    int updateByPrimaryKey(Valve record);
}