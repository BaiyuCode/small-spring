package cn.small.spring.beans.factory.support;

import cn.small.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname DefaultSingletonBeanRegistry
 * @Description TODO
 * @Date 2022/1/5 20:44
 * @Created by baiyu768
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    Map<String, Object> singletonMap = new ConcurrentHashMap<String, Object>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonMap.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonMap.put(beanName, singletonObject);
    }
}
