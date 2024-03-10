FROM openjdk:17-jdk-slim

EXPOSE 5500

COPY target/coursework_RestCardTransfer-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "myapp.jar"]