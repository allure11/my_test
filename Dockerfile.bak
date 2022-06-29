# 基础镜像使用java
FROM my/centos
# 作者
MAINTAINER zym
# VOLUME 指定临时文件目录为/tmp，在主机/var/lib/docker目录下创建了一个临时文件并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为zzyy_docker.jar
ADD ./target/demo-0.0.1-SNAPSHOT.war demo.war
ENTRYPOINT ["java","-jar","demo.war"]
#暴露6001端口作为微服务
EXPOSE 8888