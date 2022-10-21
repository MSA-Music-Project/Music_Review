#Base image 

FROM openjdk:11-jdk

#Copying over the Jar file. 

COPY target/MusicService-0.0.1-SNAPSHOT.jar music-review.jar

#The final argument should match the name and location of the copied jar file.
CMD ["java", "-jar", "music-review.jar"]
