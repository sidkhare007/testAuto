FROM maven:3.9.8-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn -q -B -DskipTests package
CMD ["mvn", "-q", "-B", "test"]
