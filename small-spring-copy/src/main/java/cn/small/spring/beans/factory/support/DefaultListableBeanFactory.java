package cn.small.spring.beans.factory.support;

import cn.small.spring.beans.factory.config.BeanDefinition;
import cn.small.spring.beans.factory.exception.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DefaultListableBeanFactory
 * @Description TODO
 * @Date 2022/1/5 21:18
 * @Created by baiyu768
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        final BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
