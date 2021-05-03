FROM amazoncorretto:8-alpine-full
MAINTAINER adhikarisubir@gmail.com
WORKDIR /app
ADD ../target/user.jar /app/user.jar
ENTRYPOINT ["java","-jar","user.jar"]