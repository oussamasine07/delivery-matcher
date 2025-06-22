FROM openjdk:23
#copy the jar file
COPY target/backend-0.0.1-SNAPSHOT.jar delivery-matcher.jar
#run the app
ENTRYPOINT ["java","-jar","/delivery-matcher.jar"]