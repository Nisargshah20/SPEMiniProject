FROM openjdk
COPY target/SPEProject-1.0-SNAPSHOT.war /home
WORKDIR /home
CMD ["java" , "-jar" , "SPEProject-1.0-SNAPSHOT.war"]