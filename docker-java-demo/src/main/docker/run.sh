#!/bin/sh

echo "Starting Java-Docker Demo"
while ! `nc -z postgres_database 5432`; do sleep 3; done
echo "Postgres Database is now up and running! ...."
exec java -Dspring.profiles.active=prod -jar /usr/local/docker-demo/@project.build.finalName@.jar
