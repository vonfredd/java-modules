FROM eclipse-temurin:22_36-jre-jammy
COPY /consumer/target/*.jar /app/app.jar
COPY /service/target/*.jar /app/ser.jar
COPY /provider/target/*.jar /app/prov.jar

ENTRYPOINT ["java","-p","/app/app.jar:/app/ser.jar:/app/prov.jar", "-m", "consumer/org.consumer.Main"]