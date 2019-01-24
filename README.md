# alibaba-cloud
本项目演示如何使用 spring cloud alibaba系列
## 引入依赖
- 版本 0.2.1.RELEASE 对应的是 Spring Cloud Finchley 版本，
- 版本 0.1.1.RELEASE 对应的是 Spring Cloud Edgware 版本。
如果需要使用已发布的版本，在 `dependencyManagement` 中添加如下配置。

	<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>0.2.1.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

然后在 `dependencies` 中添加自己所需使用的依赖即可使用。

如果您想体验最新的 BUILD-SNAPSHOT 的新功能，则可以将版本换成最新的版本，但是需要在 pom.xml 中配置 Spring BUILDSNAPSHOT 仓库，**注意: SNAPSHOT 版本随时可能更新**

	<repositories>
        <repository>
            <id>spring-snapshot</id>
            <name>Spring Snapshot Repository</name>
            <url>https://repo.spring.io/snapshot</url>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
## 服务的注册发现(Nacos Discovery)
Nacos 是阿里巴巴开源的一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。
如何使用Nacos Discovery Starter 完成 Spring Cloud 应用的服务注册与发现

1. 引入Nacos Discovery Starter

	    <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
	
2. 配置Nacos Server地址
```
server.port=18082
#服务名称
spring.application.name=cloud-client
#Nacos Server 地址
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
```
    
3. 启动类上使用 @EnableDiscoveryClient 注解开启服务注册与发现功能

4 下载 Nacos Server ：https://github.com/alibaba/nacos/releases

5. 启动 Server
- Linux/Unix/Mac 操作系统，执行命令 sh startup.sh -m standalone
- Windows 操作系统，执行命令 cmd startup.cmd
- 访问控制台：http://127.0.0.1:8848/nacos/index.html  

  **0.8版本默认登录账号的密码nacos/nacos.** 

![输入图片说明](https://images.gitee.com/uploads/images/2019/0124/125758_aa62dddb_1478371.png "屏幕截图.png")
