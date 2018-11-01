FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD client-0.0.1-SNAPSHOT.jar  app.jar
EXPOSE 9001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
