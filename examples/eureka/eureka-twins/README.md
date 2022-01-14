### eureka-twins

#### 配置启动

* 将./diamond/LunaCloud/eureka-twins-0.diamond复制到~/.diamond-client/config-data/LunaCloud/eureka-twins-0.diamond
* 将./diamond/LunaCloud/eureka-twins-1.diamond复制到~/.diamond-client/config-data/LunaCloud/eureka-twins-1.diamond
* 项目打包: ```mvn clean package```
* 项目启动节点0: ```java -jar target/eureka-twins.jar --BootId=eureka-twins-0```
* 项目启动节点1: ```java -jar target/eureka-twins.jar --BootId=eureka-twins-1```
* 节点0访问路径: [http://localhost:61223/test-eureka/](http://localhost:61223/test-eureka/)
* 节点1访问路径: [http://localhost:61224/test-eureka/](http://localhost:61224/test-eureka/)
