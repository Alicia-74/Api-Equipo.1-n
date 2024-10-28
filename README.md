# Api-Equipo.1-n

Este proyecto es una API REST desarrollada en Java con Spring Boot que permite gestionar jugadores y equipos. Los principales objetivos de esta API son crear, leer, actualizar y eliminar jugadores y equipos, así como asociar jugadores a equipos.

## Tabla de Contenidos

- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Endpoints](#endpoints)

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para desarrollar aplicaciones web y APIs REST.
- **Hibernate**: ORM utilizado para la gestión de la base de datos.
- **Maven**: Herramienta de gestión de proyectos.
- **MySQL**: Sistema de gestión de bases de datos.

## Endpoints

### Jugadores

- **Consultar todos los jugadores**  
  `GET /api/v1/jugadores`  
  Devuelve una lista de todos los jugadores con el nombre del equipo asociado.

- **Crear nuevo jugador**  
  `POST /api/v1/jugadores/insert`  
  Crea un nuevo jugador. Se requiere enviar un JSON con los datos del jugador.

  ```json
  {
      "jugadorId": 1,
      "name": "Nombre del Jugador",
      "edad": 25
  }
  ```

- **Crear nuevo equipo**  
  `POST /api/v1/equipo/insert`  
  Crea un nuevo equipo. Se requiere enviar un JSON con los datos de equipo.
  ```json
  {
      "equipoId": 1,
      "name": "Equipo Ar"
  }
  ```
  
