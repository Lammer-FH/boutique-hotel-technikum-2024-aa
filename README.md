[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/bFlAvWr6)

# Run DB with docker
```
docker run --name mysql-container-2 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=hotel_db -e MYSQL_USER=springuser -e MYSQL_PASSWORD=springpassword -p 3307:3306 -d mysql:latest
```