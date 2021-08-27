package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.ProtocolMaintain;

import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public interface IProtocolServiceImpl {

    List<ProtocolMaintain> queryList(ProtocolMaintain protocolMaintian) throws Exception;

    Integer saveProtocol(ProtocolMaintain protocolMaintian) throws Exception;

    Integer updateProcotol(ProtocolMaintain protocolMaintian) throws Exception;

    Integer deleteById(Integer protocolId) throws Exception;

    Integer deleteAllById(List<String> id) throws Exception;
}
