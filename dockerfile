FROM java:8
COPY /build/libs/ /var/www/java
WORKDIR var/www/java
EXPOSE 5891
CMD ["java","-jar","practiceHttpServer-1.0-SNAPSHOT.jar"]

