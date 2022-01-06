package cn.small.spring.beans.factory.config;

import cn.small.spring.beans.PropertyValues;

/**
 * @Classname BeanDefinition
 * @Description TODO
 * @Date 2022/1/5 21:00
 * @Created by baiyu768
 */
public class BeanDefinition {
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = (propertyValues == null ? new PropertyValues() : propertyValues);
    }

    private Class beanClass;

    private PropertyValues propertyValues;

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
