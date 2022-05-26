FROM openjdk:18-jdk-alpine3.15 
COPY target/ma-1.jar devoirdep.jar
CMD [ "java","-jar","devoirdep.jar" ]