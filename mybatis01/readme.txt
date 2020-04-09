
1 mybatis核心配置文件之mybatis-config.xml。
    a) configuration标签下的9个元素
    b) properties 引入相关配置文件，如：引入数据源配置文件 <properties resource="jdbc.properties" />
    c) settings 全局性配置，如：设置log实现为log4j, <setting name="logImpl" value="LOG4J" />
    d) typeAliases 别名配置，如：<typeAlias type="com.vic.entity.User" alias="User"/>
    e) environments 环境配置
    f) mappers 映射器配置，如：<mapper resource="mapper/UserMapper.xml" />
    2 用户mapper文件配置，resources/mapper/UserMapper.xml
3 log4j配置
    a) 引入相关依赖（有三个）
    b) log4j配置文件，log4j.properties
3 mysql驱动
    a) 引入mysql依赖

Reference
http://www.cnblogs.com/dongying/p/4031382.html