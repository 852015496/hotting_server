package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.HotAndValve;

import java.util.List;

public interface HotAndValveMapper {

    List<HotAndValve> findByJzqCode(String address);

    List<HotAndValve> selectHotMap(List addrList);
}
