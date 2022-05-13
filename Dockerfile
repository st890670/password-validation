FROM azul/zulu-openjdk-alpine:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} auth.jar
ENTRYPOINT ["java","-jar","/auth.jar"]