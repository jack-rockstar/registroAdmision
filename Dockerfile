# Utiliza una imagen base con Maven y Java instalados
FROM maven:3.8.4-openjdk-11

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml al contenedor
COPY pom.xml .

# Descarga las dependencias de Maven
RUN mvn dependency:go-offline -B

# Copia el resto de los archivos al contenedor
COPY . .

# Compila la aplicación usando Maven
RUN mvn clean package -DskipTests

# Expone el puerto en el que se ejecuta tu aplicación
EXPOSE 8080

# Comando para ejecutar tu aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar"]
