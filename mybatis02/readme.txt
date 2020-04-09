
1 mybatis-config.xml配置文件配置时，要注意节点顺序!
(properties?,settings?,typeAliases?,typeHandlers?,objectFactory?,objectWrapperFactory?,reflectorFactory?,plugins?,environments?,databaseIdProvider?,mappers?)"。
2 自定义typeHandler
    a) 定义WeiredTypeHandler extends BaseTypeHandler<T>
    b) 在类上使用注解（@MappedJdbcTypes/@MappedTypes）或者在配置文件中配置(jdbcType/javaType)
    c) 配置文件中声明 <typeHandler handler="com.vic.typehandler.WeiredTypeHandler" />
3 自定义objectFactory
    a) 定义SterilizeObjectFactory extends DefaultObjectFactory
    b) 配置文件中声明
    <objectFactory type="com.vic.objectfactory.SterilizeObjectFactory">
        <property name="hello" value="gun"/>
    </objectFactory>
    c) 在SterilizeObjectFactory类的setProperties方法里可以看到注入的属性
4 自定义plugin
    a) 定义AdverselyPlugin implements Interceptor
    b) 配置文件中声明
    <plugins>
        <plugin interceptor="com.vic.plugin.AdverselyPlugin">
            <property name="clause" value="out of my office"/>
        </plugin>
    </plugins>
    c) 在AdverselyPlugin类的setProperties方法里可以看到注入的属性
5 mappers映射器
四种方式指定
<!-- 第一种方式：通过resource指定 -->
<mapper resource="mapper/UserDao.xml"/>

<!-- 第二种方式， 通过class指定接口，进而将接口与对应的xml文件形成映射关系
     不过，使用这种方式必须保证 接口与mapper文件同名(不区分大小写)，
     我这儿接口是UserDao,那么意味着mapper文件为UserDao.xml
<mapper class="com.dy.dao.UserDao"/>
-->

<!-- 第三种方式，直接指定包，自动扫描，与方法二同理
<package name="com.dy.dao"/>
-->

<!-- 第四种方式：通过url指定mapper文件位置
<mapper url="file://........"/>
-->

Reference
https://www.cnblogs.com/dongying/p/4046488.html