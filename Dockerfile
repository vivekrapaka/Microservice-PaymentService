FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/paymentservice-0.0.1-SNAPSHOT

EXPOSE 8001

CMD ["java" ,"-jar", "app.jar"]
