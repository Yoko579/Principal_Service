FROM eclipse-temurin:21-jre
ADD target/PrincipalService-0.0.1-SNAPSHOT.jar PrincipalService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "PrincipalService-0.0.1-SNAPSHOT.jar"]