package com.hetting.hottable.server;

import com.hetting.hottable.entity.Concent;
import com.hetting.hottable.entity.ConcentMessage;
import com.hetting.hottable.entity.HotAndValve;
import com.hetting.hottable.entity.QxnHistory;
import com.hetting.hottable.mapper.ConcentMessageMapper;
import com.hetting.hottable.mapper.HotAndValveMapper;
import com.hetting.hottable.mapper.ValveMapper;
import com.hetting.hottable.mapper.ValveMessageMapper;
import com.hetting.hottable.utils.ByteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO 热表和阀门
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Component
public class HotAndValveServe {


    @Autowired
    private ValveMapper valveMapper;

    @Autowired
    private ConcentMessageMapper concentMessageMapper;

    @Autowired
    private HotAndValveMapper hotAndValveMapper;

    private static ConcentMessageMapper messageMapper;





    /*
     * @Author ZhangWenTao
     * @Description //TODO  添加集中器信息
     * @Date 2020/9/18
     * @Param [concentMessage, bytes]
     * @return java.lang.Integer
     **/
    public Integer SaveConcentMessage(Concent concentMessage,byte[] bytes){
        return concentMessageMapper.saveConcentMessage(concentMessage);
    }



    public static void updateByJzqcodeAndPydz(List<QxnHistory> historiesTmp) {
    }

    public void updateBatchById(Concent concent) {
        valveMapper.updateBatchById(concent);
    }

    public List<HotAndValve> findByJzqCode(String address) {
    return hotAndValveMapper.findByJzqCode(address);
    }
}
