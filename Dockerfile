FROM tomcat:7-jre8-alpine

# copy the WAR bundle to tomcat
COPY /target/SPEProject.war /usr/local/tomcat/webapps/SPEProject.war

# command to run
CMD ["catalina.sh", "run"]