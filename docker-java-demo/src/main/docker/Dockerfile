FROM adoptopenjdk/openjdk11:alpine-jre-nightly
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/docker-demo
RUN echo $JAVA_HOME
ADD @project.build.finalName@.jar /usr/local/docker-demo/
RUN chmod +x  /usr/local/docker-demo/@project.build.finalName@.jar
#ENTRYPOINT ["java","-jar","/usr/local/docker-demo/@project.build.finalName@.jar"]
COPY run.sh .
RUN chmod +x run.sh
ENTRYPOINT ["./run.sh"]
