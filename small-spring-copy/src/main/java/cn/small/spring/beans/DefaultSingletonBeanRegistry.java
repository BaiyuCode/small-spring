package cn.small.spring.beans;

import java.util.HashMap;
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
