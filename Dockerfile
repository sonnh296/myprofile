FROM openjdk:17

WORKDIR /app
COPY target/*.jar app.jar
RUN echo "building step"
ENTRYPOINT [ "java", "-jar" , "app.jar" ]