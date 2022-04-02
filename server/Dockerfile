FROM openjdk:11
EXPOSE 8080
ADD target/server-1.0.jar server-1.0.jar
ENTRYPOINT ["java","-jar","/server-1.0.jar"]
RUN mkdir ~/.ssh && ln -s /run/secrets/host_ssh_key ~/.ssh/id_rsa