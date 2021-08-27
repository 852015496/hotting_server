package com.hetting.hottable.server;

import com.hetting.hottable.entity.HotAndValve;
import com.hetting.hottable.entity.QxnHistory;
import com.hetting.hottable.mapper.HotMapper;
import com.hetting.hottable.mapper.ValveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO  历史记录
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Component
public class HistoryService {

    @Autowired
    private ValveMapper valveMapper;

    @Autowired
    private HotMapper hotMapper;

    private static ValveMapper messageValveMapper;


    /**
     * @Author ZhangWenTao
     * @Description //TODO  根据集中器地址查询是否有阀门记录
     * @Date 2020/9/15
     * @Param [address]
     * @return java.lang.String
     **/
    public List<HotAndValve> findByJzqCode(int flag, int all,String address) {
        messageValveMapper = valveMapper;
        return valveMapper.findByJzqCode(address);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  根据集中器地址查询集中器偏移地址
     * @Date 2020/9/15
     * @Param [address]
     * @return java.lang.Integer
     **/
    public Integer selectMaxPydzByJzqCode(String address) {
        messageValveMapper = valveMapper;
        return valveMapper.selectMaxPydzByJzqCode(address);
    }


    public List<QxnHistory> findHistoryMessage(String addr) {
        return null;
    }

    public void saveBatch(List<QxnHistory> historiesTmp) {
        return;
    }

    public void saveHistoryToSolr(List<QxnHistory> historiesTmp) {
        return;
    }

    public List<HotAndValve> findByJzqCode(String address) {
        messageValveMapper = valveMapper;
        valveMapper.findByJzqCode(address);
        return hotMapper.findByJzqCode(address);
    }
}
