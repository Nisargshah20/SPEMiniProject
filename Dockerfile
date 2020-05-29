FROM openjdk
EXPOSE 8085
COPY target/SPEProject.war /home
WORKDIR /home
CMD ["java" , "-jar" , "SPEProject.war"]