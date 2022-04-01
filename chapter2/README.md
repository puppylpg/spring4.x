# 部署
必须使用mysql5，mysql8直接连不上：
```
docker run --name mysql5.6 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.6
```
然后打开cli连上数据库使用schema下的脚本初始化一下就行。

执行的时候可以直接使用pom里的jetty插件。还能右键开debug。

测试也要用数据库真是醉了。。。

## tomcat部署
jsp里用到了jstl，但是依赖里没有，导致放到tomcat里找不到jstl
```
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
```
加上就行了。打war包放到tomcat的webapps里。

url：http://localhost:8080/chapter2-1.0/index.html

war包名就是context path。

# 其他
classpath下的spring xml配置，是web.xml里配置的`org.springframework.web.context.ContextLoaderListener`主动去加载的。
除此之外，还会加载<servletName>-servlet.xml

