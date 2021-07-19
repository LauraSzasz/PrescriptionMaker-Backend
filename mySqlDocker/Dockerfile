FROM openjdk:12
ADD target/user-mysql.jar user-mysql.jar
EXPOSE 808
ENTRYPOINT ["java", "-jar", "user-mysql.jar"]