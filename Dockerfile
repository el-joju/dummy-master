# --- ETAPA 1: COMPILACIÓN ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# --- ETAPA 2: IMAGEN FINAL ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Asegúrate de exponer el puerto correcto del Gateway (usualmente 8080 o 9001)
#EXPOSE 5050
ENTRYPOINT ["java", "-jar", "app.jar"]