package cn.small.spring.beans;

import cn.small.spring.beans.config.BeanDefinition;
import cn.small.spring.beans.exception.BeansException;

/**
 * @Classname AbstractBeanFactory
 * @Description TODO
 * @Date 2022/1/5 20:41
 * @Created by baiyu768
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name,args);
    }

    private Object doGetBean(String name,Object... args) {
        final Object singleton = getSingleton(name);
        if (singleton!=null){
            return singleton;
        }
        BeanDefinition beanDefinition= getBeanDefinition(name);
        return createBean(name,beanDefinition,args);
    }

    protected abstract BeanDefinition getBeanDefinition(String name) ;
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object... args);
}
