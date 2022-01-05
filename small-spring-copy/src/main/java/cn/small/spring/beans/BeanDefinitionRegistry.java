package cn.small.spring.beans;

import cn.small.spring.beans.config.BeanDefinition;

/**
 * @Classname BeanDefinitionRegistry
 * @Description TODO
 * @Date 2022/1/5 21:17
 * @Created by baiyu768
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
