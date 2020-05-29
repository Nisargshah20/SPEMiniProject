FROM openjdk
EXPOSE 8085
ADD target/SPEProject.war SPEProject.war
ENTRYPOINT ["java" , "-jar" , "SPEProject.war"]