FROM openjdk:11-jre-slim

EXPOSE 9001

COPY maven/order-app.jar ./
COPY maven/logback.xml ./

#WORKDIR /usr/app

ENTRYPOINT ["java","-jar","-Dlogging.config=./logback.xml","./order-app.jar"]