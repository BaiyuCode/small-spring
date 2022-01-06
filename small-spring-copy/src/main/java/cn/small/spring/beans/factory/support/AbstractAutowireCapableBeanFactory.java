package cn.small.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.small.spring.beans.PropertyValue;
import cn.small.spring.beans.PropertyValues;
import cn.small.spring.beans.factory.config.BeanDefinition;
import cn.small.spring.beans.factory.config.BeanReference;
import cn.small.spring.beans.factory.support.InstantiationStrategy;
import cn.small.spring.beans.factory.exception.BeansException;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * @Classname AbstractAutowireCapableBeanFactory
 * @Description TODO
 * @Date 2022/1/5 21:06
 * @Created by baiyu768
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        final Class beanClass = beanDefinition.getBeanClass();
        Object instance = null;
        try {
            instance = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, instance, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("createBean报错", e);
        }
        addSingleton(beanName, instance);
        return instance;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;
        final Class<?> beanClass = beanDefinition.getBeanClass();
        final Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (null != args && declaredConstructor.getParameterTypes().length == args.length) {
                constructor = declaredConstructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            final PropertyValues propertyValues = beanDefinition.getPropertyValues();
            final List<PropertyValue> propertyValueList = propertyValues.getPropertyValueList();
            for (PropertyValue propertyValue : propertyValueList) {
                final String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    final BeanReference re = (BeanReference) value;
                    value = getBean(re.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("error set property where create bean[" + beanName + "]", e);
        }
    }
}
