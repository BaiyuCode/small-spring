package cn.small.spring.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PropertyValues
 * @Description TODO
 * @Date 2022/1/6 20:58
 * @Created by baiyu768
 */
@Data
public class PropertyValues {
    private final List<PropertyValue> propertyValueList=new ArrayList<>();

    public void addProperty(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getProperties(){
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

}

