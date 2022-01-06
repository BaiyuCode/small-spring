package cn.small.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname PropertyValues
 * @Description TODO
 * @Date 2022/1/6 20:58
 * @Created by baiyu768
 */
@Data
@AllArgsConstructor
public class PropertyValue{
    private String name;
    private Object value;
}

