package com.hetting.hottable.server;

import com.hetting.hottable.entity.DataContrastVO;
import com.hetting.hottable.entity.Hot;
import com.hetting.hottable.entity.MeterData;
import com.hetting.hottable.mapper.ConcentMapper;
import com.hetting.hottable.mapper.HotMapper;
import com.hetting.hottable.mapper.MeterDataMapper;
import com.hetting.hottable.server.impl.IMeterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("materDataService")
public class MeterDataService implements IMeterDataService {

    @Autowired
    private MeterDataMapper materDataMapper;

    @Autowired
    private HotMapper hotMapper;

    @Autowired
    private ConcentMapper concentMapper;


    /**
     * @Author ZhangWenTao
     * @Description //TODO  读取抄表数据
     * @Date 2020/4/26
     * @Param [materData]
     * @return java.util.List<com.hetting.hottable.entity.MaterData>
     **/
    @Override
    public List<MeterData> materMessageList(MeterData materData) throws Exception{
        return materDataMapper.materMessageList(materData);
    }

    @Override
    public Integer deleteByMeterDataMessage(List id) throws Exception{
        Map<String,List<String>> map = new HashMap<>();
        map.put("id",id);
        return materDataMapper.deleteByMeterDataMessage(map);
    }

    @Transactional
    @Override
    public ArrayList<Object> hotAndVolContrast(DataContrastVO dataContrastVO) {
        Hot addr1 = hotMapper.hotAndContrast(dataContrastVO);
        System.err.println(addr1);
        Hot addr2 = hotMapper.hotAndContrastTwo(dataContrastVO);
        System.err.println(addr2);
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(addr1);
        arr.add(addr2);
        return arr;
    }

    @Override
    public Integer selectConcentCodeById(List id) {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("id",id);
        return materDataMapper.selectConcentCodeById(map);
    }

    public Object findMetaData(String addr) {
        return null;
    }

    //点名抄表
    public static void insertList(List<MeterData> callReadings) {
        return;
    }
    public static void updateResponse(List<MeterData> qxnCallReadings) {
        return;
    }

    //点名阀控
    public void insertListValveContol(List<MeterData> callControls) {
        return;
    }

    public static void updateByJzqCodeAndAddr(List<MeterData> qxnCallControls) {
        return;
    }



    public void findPutTimeFlag(String addr, long currentTimeMillis) {
    }


}
