FROM openjdk
EXPOSE 8085
ADD target/SPEProject.war SPEProject.war
WORKDIR /home
ENTRYPOINT ["java" , "-jar" , "SPEProject.war"]