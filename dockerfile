From openjdk:11
copy ./target/demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]