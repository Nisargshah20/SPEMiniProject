FROM openjdk
EXPOSE 8080
ADD target/SPEProject.war SPEProject.war
ENTRYPOINT ["java" , "-jar" , "SPEProject.war"]