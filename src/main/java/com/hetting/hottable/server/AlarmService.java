package com.hetting.hottable.server;


import com.hetting.hottable.entity.Alarm;
import com.hetting.hottable.entity.AlarmDetails;
import com.hetting.hottable.mapper.AlarmDetailsMapper;
import com.hetting.hottable.mapper.AlarmMapper;
import com.hetting.hottable.server.impl.IAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("alarmService")
public class AlarmService implements IAlarmService {

    @Autowired
    private AlarmMapper alarmMapper;

    @Autowired
    private AlarmDetailsMapper alarmDetailsMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Object saveFacility() throws Exception{
        alarmMapper.saveFacility();
        List<Alarm> occurTime = alarmMapper.queryList();
        for (Alarm list:occurTime) {
            if(null == list.getOccurTime()){
                Alarm alarm = new Alarm();
                alarm.setAlarmId(list.getAlarmId());
                alarm.setOccurTime(new Date());
                alarmMapper.updateOccurTime(alarm);
            }
        }
        return "创建发生时间";
    /*    Alarm alarm = new Alarm();
        List<Alarm> alarms = alarmMapper.facilityList(alarm);
        for (int i = 0; i <alarms.size() ; i++) {
            Long alarmId = alarms.get(i).getAlarmId();
            System.err.println(alarmId);
            AlarmDetails alarmDetails = new AlarmDetails();
            alarmDetails.setAlarmId(alarmId.intValue());
            alarmDetails.setDisposeCondition("新信息上报");
            alarmDetails.setDisposeStatus(1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.format(new Date());
            alarmDetails.setUpdateTime(new Date());
            alarmDetailsMapper.addAlarmIdAndCon(alarmDetails);
           *//* List<AlarmDetails> details = alarmDetailsMapper.queryFacilityList(alarmDetails);
            for (int j = 0; j <details.size() ; j++) {
                Integer id = details.get(i).getAlarmId();
                System.err.println(id);
                if( id == alarmId.intValue() &&  id == null){
                   break;
                }else{
                    alarmDetails.setAlarmId(alarmId.intValue());
                    alarmDetails.setDisposeCondition("新信息上报");
                    alarmDetails.setDisposeStatus(1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                    simpleDateFormat.format(new Date());
                    alarmDetails.setUpdateTime(new Date());
                    alarmDetailsMapper.addAlarmIdAndCon(alarmDetails);
                }
            }*//*
        }
        return 1;*/
    }

    @Override
    public List<Alarm> unfinishedFacility(Alarm alarm) throws Exception{
        return alarmMapper.unfinishedFacility(alarm);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveMessageContent(AlarmDetails alarmDetails) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.err.println(simpleDateFormat.format(new Date()));
        alarmDetails.setUpdateTime(new Date());
        alarmDetailsMapper.insertSelective(alarmDetails);
        Alarm alarm = new Alarm();
        Long am = Long.valueOf(alarmDetails.getAlarmId());
        alarm.setAlarmId(am);
        alarm.setDisposeStatus(alarmDetails.getDisposeStatus());
        SimpleDateFormat updateMap = new SimpleDateFormat();
        System.err.println(updateMap.format(new Date()));
        alarm.setUpdateTime(new Date());
        return alarmMapper.updateByPrimaryKeySelective(alarm);
    }

    @Override
    public List<AlarmDetails> queryFacilityList(AlarmDetails alarmDetails) throws Exception{
        return alarmDetailsMapper.queryFacilityList(alarmDetails);
    }

    @Override
    public Integer updateAlarmStatus(Alarm alarm) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.err.println(simpleDateFormat.format(new Date()));
        alarm.setUpdateTime(new Date());
        return alarmMapper.updateByPrimaryKeySelective(alarm);
    }

    @Override
    public List<Alarm> processedFacility(Alarm alarm) throws Exception{
        return alarmMapper.processedFacility(alarm);
    }

    @Override
    public List<Alarm> alarmsImg(Alarm alarm) throws Exception{
        return alarmMapper.alarmsImg(alarm);
    }

    @Override
    public List<Alarm> facilityList(Alarm alarm) throws Exception {
        return alarmMapper.facilityList(alarm);
    }

}
