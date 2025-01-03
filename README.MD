# Proyecto Nequi

Este proyecto es una aplicación que utiliza **Spring Boot** como backend, **MySQL** como base de datos, y está configurado para ejecutarse utilizando **Docker Compose**.

## Requisitos previos

Asegúrate de tener instalados los siguientes programas en tu máquina:

- Git
- Docker
- Docker Compose

## Instrucciones para ejecutar el proyecto

### 1. Clonar el repositorio

Clona este repositorio en tu máquina local utilizando Git.

```bash
git clone https://github.com/kamilo9809/pruebaNequi.git
cd pruebaNequi
```

### 2. Configuración del entorno

El proyecto ya está configurado para ejecutarse con Docker. La base de datos y la aplicación están definidas en el archivo `docker-compose.yml`.

Si deseas cambiar las configuraciones, revisa las siguientes variables en el archivo `docker-compose.yml`:

#### Base de datos:

- `MYSQL_DATABASE`: nequiPrueba.
- `MYSQL_USER`: nequi.
- `MYSQL_PASSWORD`: nequi.
- `MYSQL_ROOT_PASSWORD`: root_password.

### 3. Levantar los servicios con Docker Compose

Ejecuta el siguiente comando para construir y levantar los contenedores:

```bash
docker-compose up --build
```

### 4. Verificar los servicios

- **Backend**: Accede al backend en tu navegador o herramienta API (como Postman) en la dirección:
  [http://localhost:8080](http://localhost:8080).

- **Base de datos**: Puedes conectarte al contenedor de MySQL utilizando herramientas como MySQL Workbench. Usa las siguientes credenciales:

  - **Host**: localhost
  - **Puerto**: 3306
  - **Usuario**: nequi
  - **Contraseña**: nequi

### 5. Apagar los servicios

Cuando hayas terminado, detén y elimina los contenedores ejecutando:

```bash
docker-compose down
```
