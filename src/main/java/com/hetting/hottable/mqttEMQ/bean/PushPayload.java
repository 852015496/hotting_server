package com.hetting.hottable.mqttEMQ.bean;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * mqtt 消息推送实体
 *
 * @author
 * @date
 */
@Slf4j
@Setter
@Getter
public class PushPayload {

    //----------------集中器设置---------------------
    //集中器Id
    private String Edge_ID;
    //集中器地址代码
    private String Name;
    //时间戳
    private String TimeStamp;
    //集中器地址
    private String Address;
    //自动报告持续时间
    private String AutoReportDuration;
    //数据
    private String Data;


    //--------------点名抄表-----------------
    private String MeterRecords;
    //--------------点名阀控-----------------
    //阀门控制模式
    private String Type;
    //阀门信息
    private String Gate;

    public PushPayload(String edge_ID, String name, String timeStamp, String address, String autoReportDuration, String data, String meterRecords, String type, String gate) {
        Edge_ID = edge_ID;
        Name = name;
        TimeStamp = timeStamp;
        Address = address;
        AutoReportDuration = autoReportDuration;
        Data = data;
        MeterRecords = meterRecords;
        Type = type;
        Gate = gate;
    }

    public static class Builder{
        //----------------集中器设置---------------------
        //集中器Id
        private String Edge_ID;
        //集中器地址代码
        private String Name;
        //时间戳
        private String TimeStamp;
        //集中器地址
        private String Address;
        //自动报告持续时间
        private String AutoReportDuration;
        //数据
        private String Data;


        //--------------点名抄表-----------------
        private String MeterRecords;
        //--------------点名阀控-----------------
        //阀门控制模式
        private String Type;
        //阀门信息
        private String Gate;

        public Builder setMeterRecords(String MeterRecords) {
            this.MeterRecords = MeterRecords;
            return this;
        }

        public Builder setType(String Type) {
            this.Type = Type;
            return this;
        }

        public Builder setGate(String Gate) {
            this.Gate = Gate;
            return this;
        }

        public Builder setName(String Name) {
            this.Name = Name;
            return this;
        }

        public Builder setTimeStamp(String TimeStamp) {
            this.TimeStamp = TimeStamp;
            return this;
        }

        public Builder setAddress(String Address) {
            this.Address = Address;
            return this;
        }

        public Builder setAutoReportDuration(String AutoReportDuration) {
            this.AutoReportDuration = AutoReportDuration;
            return this;
        }

        public Builder setEdge_ID(String Edge_ID) {
            this.Edge_ID = Edge_ID;
            return this;
        }

        public Builder setData(String Data) {
            this.Data = Data;
            return this;
        }

        public PushPayload bulid(){
            return new PushPayload(Edge_ID,Name,TimeStamp,Address,AutoReportDuration,Data,MeterRecords,Type,Gate);
        }
    }


    public static Builder getPushPayloadBuider(){
        return new Builder();
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

}
