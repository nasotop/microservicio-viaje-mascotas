FROM openjdk:21-ea-24-oracle

WORKDIR /app
COPY build/libs/*.jar app.jar
COPY Wallet_BDBimestre1 /Wallet_BDBimestre1
EXPOSE 8080

CMD ["java","-jar","app.jar"]