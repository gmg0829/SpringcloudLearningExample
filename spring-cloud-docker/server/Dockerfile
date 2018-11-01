FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
