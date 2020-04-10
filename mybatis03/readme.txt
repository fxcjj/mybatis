1 插入数据后返回主键（表是自增）
a) 方式1
useGeneratedKeys="true" keyProperty="id"
b) 方式2
使用selectKey元素
c) 参考 com.vic.UserTest#testInsertAndGetId1, com.vic.UserTest#testInsertAndGetId2

Reference
https://www.cnblogs.com/dongying/p/4048828.html
https://mybatis.org/mybatis-3/zh/sqlmap-xml.html