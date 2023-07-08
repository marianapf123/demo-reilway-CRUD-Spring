FROM amazoncorretto:11-alpine-jdk
MAINTAINER ABE
COPY --from=build /target/practicaswrest-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]
