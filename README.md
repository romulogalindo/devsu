# README #
Devsu
Desarrollo de solución propuesta

### Base de datos ###

Ejecutar sobre el schema public de una base de datos postgres. No es necesario generar un schema particular.
Ejecutar: src/resources/script_db.sql

### POSTMAN ###

Todos los endpoint estan en el archivo 
Ejecutar: src/resources/devsu.postman_collection.json

### DOCKER ###

Antes de compilar se debe actualizar la IP de la base de datos a conectar. Recordar que la ip 127.0.0.1 no funcionaria.
Editar: src/resources/application.properties
Ejecutar: docker build .

Gracias!