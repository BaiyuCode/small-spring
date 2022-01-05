package cn.small.spring.beans.config;

/**
 * @Classname BeanDefinition
 * @Description TODO
 * @Date 2022/1/5 21:00
 * @Created by baiyu768
 */
public class BeanDefinition {
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    private Class beanClass;

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
