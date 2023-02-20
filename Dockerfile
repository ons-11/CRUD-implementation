
FROM openjdk:17
COPY  --from=build /target/users.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]