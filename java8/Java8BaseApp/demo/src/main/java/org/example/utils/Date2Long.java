package org.example.utils;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/5/27--@23:05
 */
public class Date2Long implements ObjectWriter {
    @Override
    public void write(JSONWriter jsonWriter, Object object, Object fieldName, Type fieldType, long features) {
        if(object instanceof Date){
            HashMap<Object, Object> map = new HashMap<>();
            map.put(fieldName,((Date) object).getTime());
            jsonWriter.write(map);
        }
    }
}
