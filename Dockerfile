FROM openjdk
EXPOSE 8085
RUN mkdir /speproject
COPY target/SPEProject.war /speproject
WORKDIR /speproject
CMD ["java" , "-jar" , "SPEProject.war"]