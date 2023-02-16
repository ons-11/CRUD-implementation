FROM maven as build
WORKDIR /app
COPY . .
RUN mvn install

FROM openjdk:8
WORKDIR /app
COPY --from=build /app/target/users.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]