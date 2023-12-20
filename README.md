# TechnicalTest techForb Backend

es un proyecto backend siguiendo los principios RESTful propuesta por techForb con el fin de conocer las habilidades tecnicas del postulante

## Requisitos Previos

Asegúrate de tener instalados los siguientes requisitos antes de comenzar:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Configuración

### 1. Clona el repositorio:

```bash
git clone git@github.com:nicolasBakanowski/technicalTechForb.git
cd technicalTechForb
```

## Ejecucion

### 1. Levanta el servicio de base de datos

Ejecuta el siguiente comando para iniciar el servicio de base de datos
de esta manera no necesitas cambiar el usuario y contraseña en servicio de spring

```bash
docker-compose up -d
```

### 2 . Ejecuta la aplicación Spring Boot

ejecutamos el comando para correr la aplicacion de springboot, si se inicia la applicacion por primera vez los archivos de migracion surgiran efecto en la base de datos, por lo que esta ya estaria completamente funcional.

```bash
./mvnw spring-boot:run
```
