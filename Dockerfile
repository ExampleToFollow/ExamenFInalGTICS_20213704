FROM openjdk:21-jdk-oraclelinux7
VOLUME /tmp
EXPOSE 8080
ADD /target/ExamenFInalGTICS_20213704-0.0.1-SNAPSHOT.jar proyecto.jar
ENTRYPOINT  ["java" , "-jar" , "proyecto.jar"]