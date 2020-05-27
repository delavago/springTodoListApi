# **Prerequisites**

**install dependencies**
* install java 8 or newer [here](https://www.java.com/en/download/)
* install maven from [here](https://maven.apache.org/download.cgi)
    * steps to install maven for your system [here](https://www.baeldung.com/install-maven-on-windows-linux-mac)
* install Postgresql for you system [here](https://www.postgresql.org/download/)

##### **Bonus!**
You can use the local installation of Postgresql installed on your machine through the link above which
works just find.

For this project i used postgresql in a docker container. 

Get started by installing docker for your system [here](https://docs.docker.com/get-docker/)

NOTE docker works on all platforms, but if you are on windows 10 non pro versions use this [link](https://docs.docker.com/docker-for-windows/install-windows-home/)

## **Getting Started**

* clone the repository
* configure spring boot to use your Postgresql instance
    * in `src/main/resources/` open `application.yml` this is the database config file that is used for this project
    * `jdbc:postgresql://localhost:5432/todoapp` is the connect to you local postgres instance where `todoApp` is that name of the database that we will have to create
        * in an update i will make this process automatic
    * ``username: postgres`` is the username of your postgres logic credentials where `postgres` is a default credential provided by postgres
    * ``password: simplePassword`` is the password to your postgres database system change this to your set password
    * everything else can stay the same

You are ready to run the application now. For those who want to run Postgress in a docker container follow the steps below.

* make sure you have docker installed and running
* create a docker container
    * `docker run --name-of-container -e POSTGRES_PASSWORD=yourPassword -d -p 5432:5432 postgres:alpine`
        * `--name` naming your container
        * `-e` setting environment variables
        * `-d` run in detached mode
        * `-p` map container post to computer port
        * `postgres:alpine` pulls the smallest packaged version of postgress for docker
    * create the database in the the container
        * `docker ps` to list all running container
        * copy the id of the container we just made
        * `docker exec -it containerId bin/bash`
            * `containerId` is the container Id
        * run `psql -U postgres` to enter into the container's postgresql CLI
        * run `CREATE DATABASE todoapp;` to create the database;
        * done

now run the maven project

URLs: 
* POST `http://localhost:8080/api/todo` to create a todo item
    * request body format: ``{
                             	"title": "item2",
                             	"description" : "Second Item"
                             }``
* GET `http://localhost:8080/api/todo` to get all notes
* GET `http://localhost:8080/api/todo/itemId` where `itemId` is the id of the individual items you wanna get
* PUT `http://localhost:8080/api/todo/itemId` where `itemId` is the id of the individual items you wanna update
    * request body format: ``{
                                   	"title": "item2",
                                   	"description" : "Second Item"
                                   }``
* DELETE `http://localhost:8080/api/todo/itemId` where `itemId` is the id of the individual items you wanna delete