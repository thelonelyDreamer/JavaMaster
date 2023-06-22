package org.example.utils;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.reader.ObjectReader;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/5/28--@9:32
 */
public class Long2Date implements ObjectReader<Date> {
    @Override
    public Date readObject(JSONReader jsonReader, Type fieldType, Object fieldName, long features) {
        Map<String, Object> map = jsonReader.readObject();
        if(map.containsKey(fieldName)){
            Object o = map.get(fieldName);
           if(o instanceof String){
               return new Date(Long.valueOf((String) o));
           }else if(o instanceof Long){
               return new Date((Long)o);
           }
        }
        return null;
    }
}
