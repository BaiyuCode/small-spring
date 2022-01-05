package cn.small.spring.beans;

import cn.small.spring.beans.exception.BeansException;

/**
 * @Classname BeanFactory
 * @Description TODO
 * @Date 2022/1/5 20:36
 * @Created by baiyu768
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
    Object getBean(String name,Object...args) throws BeansException;
}
