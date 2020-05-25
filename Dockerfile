FROM openjdk
COPY target/SPEProject.war /home
WORKDIR /home
CMD ["java" , "-jar" , "SPEProject.war"]