package cn.small.spring.beans;

import cn.small.spring.beans.config.BeanDefinition;
import cn.small.spring.beans.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * @Classname AbstractAutowireCapableBeanFactory
 * @Description TODO
 * @Date 2022/1/5 21:06
 * @Created by baiyu768
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    private InstantiationStrategy instantiationStrategy=new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName,BeanDefinition beanDefinition,Object... args) {
        final Class beanClass = beanDefinition.getBeanClass();
        Object instance=null;
        try {
            instance = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
           throw new BeansException("createBean报错",e);
        }
        addSingleton(beanName,instance);
        return instance;
    }

      protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
          Constructor constructor=null;
          final Class<?> beanClass = beanDefinition.getBeanClass();
          final Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
          for (Constructor<?> declaredConstructor : declaredConstructors) {
              if (null!=args&&declaredConstructor.getParameterTypes().length==args.length){
                  constructor=declaredConstructor;
                  break;
              }
          }
          return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructor,args);
      }

}
