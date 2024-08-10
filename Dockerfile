FROM eclipse-temurin:17-jre-alpine
EXPOSE 8080
ADD target/reviews-0.0.2-SNAPSHOT.jar reviews-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["sh","-c","java -jar /reviews-0.0.2-SNAPSHOT.jar"]
