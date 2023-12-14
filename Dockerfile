FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY ./pom.xml .

RUN mvn dependency:go-offline -B

COPY . .
RUN mvn package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/tu-artifact-id-1.0.0.jar"]
