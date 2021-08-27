package com.hetting.hottable.utils;

import java.util.*;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public class JSONArrayBuilder {
    List<Map<String,String>> ls = new LinkedList<Map<String,String>>();
    Map<String,String> object = null;

    public void newObject(){
        object = new LinkedHashMap<String,String>();
    }

    public void endObject(){
        if(null==object){
            throw new RuntimeException("请先调用newObject()");
        }

        ls.add(object);
    }

    public void put(String key, String value){
        if(null==object){
            throw new RuntimeException("请先调用newObject()");
        }

        this.object.put(replaceJsonChar(key), replaceJsonChar(value));
    }

//	public void add(Map<String,String> item){
//		ls.add(item);
//	}

    public void add(JSONArrayBuilder ja){
        add(ja.getJsonArray());
    }

    public void add(List<Map<String,String>> ls){
        this.ls.addAll(ls);
    }

    public List<Map<String,String>> getJsonArray(){
        return ls;
    }

    /**
     * 将数据转换成json格式字符�?
     * @return
     */
    public String toJsonString(){
        String sb = "";
        String key = null;
        String value = null;
        Iterator<String> keys = null;

        sb  = "[";

        for(Map<String,String> item: ls){
            keys = item.keySet().iterator();
            sb += "{";

            while(keys.hasNext()){
                key = keys.next();
                value = item.get(key);
//                sb +=  key +":";
//                sb +=  value +",";
                sb += "\""+ key +"\":";
                sb += "\""+ value +"\",";
            }

            if(sb.endsWith(",")){
                sb = sb.substring(0, sb.length()-1);
            }
            sb += "},";
        }

        if(sb.endsWith(",") ){
            sb = sb.substring(0, sb.length()-1);
        }

        sb += "]";

        sb = sb.replaceAll("\\{\\},", "");
        sb = sb.replaceAll("\\{\\}", "");

        return sb;
    }

    public String toString(){
        return toJsonString();
    }

    private String replaceJsonChar(String str){
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();

        for(char c: chs){
            switch (c) {
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    sb.append(c);
            }
        }

        return sb.toString();
    }
}
