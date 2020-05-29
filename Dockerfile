FROM openjdk
EXPOSE 8085
COPY target/SPEProject.war /home/nisarg
WORKDIR /home/nisarg
CMD ["java" , "-jar" , "SPEProject.war"]