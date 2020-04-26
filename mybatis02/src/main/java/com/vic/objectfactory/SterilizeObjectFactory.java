package com.vic.objectfactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * 自定义objectFactory
 * @author Victor
 * date: 2020/4/9 11:18
 */
public class SterilizeObjectFactory extends DefaultObjectFactory {

    private String hello;

    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("SterilizeObjectFactory hello属性值: " + hello); // 这里为null
        System.out.println("SterilizeObjectFactory properties中hello属性值: " + properties.getProperty("hello")); // 打印gun
        super.setProperties(properties);
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
