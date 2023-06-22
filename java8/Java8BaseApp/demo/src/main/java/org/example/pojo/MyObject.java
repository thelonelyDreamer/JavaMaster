package org.example.pojo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;
import org.example.utils.Date2Long;
import org.example.utils.Long2Date;

import java.util.Date;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/5/27--@22:32
 */
@Data
@Accessors(chain = true)
public class MyObject {
    private Integer id;
    private String name;
    @JSONField(serializeUsing= Date2Long.class,deserializeUsing = Long2Date.class)
    private Date date;
}
