### eureka-triple

#### 配置启动

* 将./diamond/LunaCloud/eureka-triple-0.diamond复制到~/.diamond-client/config-data/LunaCloud/eureka-triple-0.diamond
* 将./diamond/LunaCloud/eureka-triple-1.diamond复制到~/.diamond-client/config-data/LunaCloud/eureka-triple-1.diamond
* 将./diamond/LunaCloud/eureka-triple-2.diamond复制到~/.diamond-client/config-data/LunaCloud/eureka-triple-2.diamond
* 添加hosts: ```127.0.0.1 peer1```
* 添加hosts: ```127.0.0.1 peer2```
* 添加hosts: ```127.0.0.1 peer3```
* 项目打包: ```mvn clean package```
* 项目启动节点0: ```java -jar target/eureka-triple.jar --BootId=eureka-triple-0```
* 项目启动节点1: ```java -jar target/eureka-triple.jar --BootId=eureka-triple-1```
* 项目启动节点1: ```java -jar target/eureka-triple.jar --BootId=eureka-triple-2```
* 节点0访问路径: [http://localhost:61225/test-eureka/](http://localhost:61225/test-eureka/)
* 节点1访问路径: [http://localhost:61226/test-eureka/](http://localhost:61226/test-eureka/)
* 节点2访问路径: [http://localhost:61227/test-eureka/](http://localhost:61227/test-eureka/)
