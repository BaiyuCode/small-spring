package cn.small.spring.beans.factory.config;

/**
 * @Classname SingletonBeanRegistry
 * @Description TODO
 * @Date 2022/1/5 20:43
 * @Created by baiyu768
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
