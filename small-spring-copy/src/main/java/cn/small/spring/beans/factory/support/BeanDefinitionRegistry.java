package cn.small.spring.beans.factory.support;

import cn.small.spring.beans.factory.config.BeanDefinition;

/**
 * @Classname BeanDefinitionRegistry
 * @Description TODO
 * @Date 2022/1/5 21:17
 * @Created by baiyu768
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
