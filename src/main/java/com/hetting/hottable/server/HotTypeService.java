package com.hetting.hottable.server;

import com.hetting.hottable.entity.*;
import com.hetting.hottable.mapper.*;
import com.hetting.hottable.server.impl.IHotTypeService;
import jdk.nashorn.internal.ir.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotTypeService implements IHotTypeService {

    @Autowired
    private HotTypeMaintainMapper hotTypeMaintainMapper;

    @Autowired
    private SupplierMaintainMapper supplierMaintainMapper;

    @Autowired
    private ProtocolMaintainMapper protocolMaintainMapper;

    @Autowired
    private HotMapper hotMapper;

    @Autowired
    private ValveMapper valveMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ValveTypeMaintainMapper valveTypeMaintainMapper;

    @Autowired
    private HotMessageMapper hotMessageMapper;

    @Override
    public List<HotTypeMaintain> queryList(HotTypeMaintain hotTypeMaintain) throws Exception{
        return hotTypeMaintainMapper.queryList(hotTypeMaintain);
    }

    @Override
    public Integer saveHotType(HotTypeMaintain hotTypeMaintain) throws Exception{
        hotTypeMaintain.setCreatTime(new Date());
        return hotTypeMaintainMapper.insertSelective(hotTypeMaintain);
    }

    @Override
    public Integer updateProcotol(HotTypeMaintain hotTypeMaintain) throws Exception{
        return hotTypeMaintainMapper.updateByPrimaryKeySelective(hotTypeMaintain);
    }

    @Override
    public Integer deleteById(Integer hottypeId) throws Exception{
        return hotTypeMaintainMapper.deleteByPrimaryKey(hottypeId);
    }

    @Override
    public Integer deleteAllById(List<String> id) throws Exception{
        Map<String, List<String>> map = new HashMap<>();
        map.put("id",id);
        return hotTypeMaintainMapper.deleteAllById(map);
    }

    @Override
    public List<SupplierMaintain> hotAndDealerName() throws Exception{
        return supplierMaintainMapper.hotAndDealerName();
    }

    @Override
    public List<ProtocolMaintain> protocolName() throws Exception{
        return protocolMaintainMapper.protoColName();
    }

    public List<HotMessage> findListByJzq(String jzp) {
        return HotMessageMapper.findListByJzq(jzp);
    }

    public String findCjdm(String id) {
        return hotMapper.findCjdm(id);
    }

    public HotTypeMaintain findUniqueByProperty(String protocol_code, Object value) {
        hotTypeMaintainMapper.findProtocolCode(protocol_code,value);
        return valveTypeMaintainMapper.finprotocolCode(protocol_code,value);
    }

    @Transactional(readOnly = false)
    public void save(FacilityAllMessage qr) {
        hotTypeMaintainMapper.save(qr);
        valveTypeMaintainMapper.save(qr);
    }

    @Transactional(readOnly = false)
    public  double heatApportionFee(double current,double last) {
        DecimalFormat df = new DecimalFormat("#.##");
        //在一个分摊周期Tf内，大口径热量表走的热量数Q = 热量表本次读数 - 热量表上次读数
        double Q = current - last;
        //Q为负数
        if (Q < 0) {
            //Max为热量表最大示数
            double Max = 10.0;
            //Max可以从热量表的上次读数推断出来
            for (int i = 0; i < 20; i++) {
                if (Max > last)
                    break;
                Max = Max * 10.0;
            }
            double Q1 = Max - last;
            Q = current + Q1;
            return Double.parseDouble(df.format(Q));
        } else {
            return Double.parseDouble(df.format(Q));
        }
    }

    public List<FacilityAllMessage> findList4(FacilityAllMessage qr) {
        return hotTypeMaintainMapper.findList4(qr);
    }



}
