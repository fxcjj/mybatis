package com.vic.plugin;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

import java.util.Properties;

/**
 * 自定义plugin
 * @author Victor
 * date: 2020/4/9 11:31
 */
public class AdverselyPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("AdverselyPlugin properties中clause属性值: " + properties.getProperty("clause"));
    }
}
