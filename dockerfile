FROM java:8
COPY /build/libs/ /var/www/java
WORKDIR var/www/java
EXPOSE 8080
CMD ["java","-jar","practiceHttpServer-1.0-SNAPSHOT.jar"]

