# 项目目录简介
configRespo 配置仓库  
spring-cloud--eureka1 注册中心1  
pring-cloud--eureka2 注册中心2  
spring-cloud-config  高可用的分布式配置中心   
spring-cloud-docker doker和SpringCloud的结合(docker和docker-compose)   
spring-cloud-feign  feign调用  
spring-cloud-ribbon ribbon调用  
spring-cloud-server 生产者   
spring-cloud-turbine   断路器聚合监控   
spring-cloud-zipkin   服务链路追踪   
spring-cloud-zuul 路由网关(实现黑白名单、限流、验证号token)


# docker常用命令
## 镜像命令
搜索镜像：docker search java  
下载镜像：docker pull java  
列出镜像：docker images  
删除指定镜像：docker rmi hello  
删除所有镜像 docker rmi -f $(docker images)
## 容器命令
新建并启动容器：docker run  
列出容器 docker ps  
停止容器 docker stop  
强制停止容器 docker kill  
重启容器 docker restart  
进入容器 docker attach  
删除容器 docker rm

## Dockerfile常用命令
ADD 复制文件  
COPY 复制文件  （不支持URL和压缩包）  
ARG 设置构建参数  
ENV 设置环境变量
CMD 容器启动命令  
ENTRYPOINT 入口点  
EXPOSE 生命暴露的接口  
FROM指定基础镜像  
LABEL 为镜像添加元数据  
MAINTAINER 指定维护者信息  
RUN 执行命令  
USER 设置用户  
VOLUME 指定挂载点  
WORKDIR 指定工作目录

## Docker Hub命令
登录  docker login  
推送镜像 docker push

## maven的docker插件推送镜像步骤
第一步：设置maven的setting配置
 
    <server>
        <id>docker-hub</id>
        <username>用户名</username>
        <password>密码</password>
        <configuration>
            <email>邮箱</email>
        </configuration>
    </server>
第二步：修改pom

    增加<serverId>docker-hub</serverId>
第三步：执行命令

    mvn clean package docker:build -DpushImage
    
# docker-compose 常用命令：
docker-compose 
   build 构建或重新构建项目中的服务容器  
   kill   停止指定服务的容器  
   logs 查看服务日志输出   
   down 停止up命令所启动的容器  
   exec 进入指定的容器  
   port 打印绑定的公共端口  
   ps 列出所有容器  
   pull 下载镜像   
   rm 删除镜像   
   stop 停止已运行打得容器  
   up 启动
 # Docker Machine 常用命令：
docker-machine  
    create  创建虚拟机   
    rm 移除虚拟机   
    ssh登录虚拟机  
    env 客户端配置环境变量  
    inspect  检查机子信息  
    ls 查看虚拟机列表  
    status  查看虚拟机状态  
    start 启动虚拟机   
    stop  停止虚拟机        
    restart 重启虚拟机

 

