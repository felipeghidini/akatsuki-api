# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia pom.xml e baixa dependências em cache
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte e compila
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Porta exposta
EXPOSE 8080

# Profile padrão = prod, mas pode ser sobrescrito em runtime
ENV SPRING_PROFILES_ACTIVE=prod

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
