#!/bin/bash

# Pull new changes
git pull

# Prepare Jar
mvn clean
mvn package

# Ensure, that docker-compose stopped
docker-compose stop

# Add environment variables
export BOT_NAME=$1
export BOT_TOKE=$2
export BOT_DB_USERNAME='prod_jrtb_db_user'
export BOT_DB_PASSWORD='prod_jrtb_db_password'

# Start new deployment
docker-compose up --build -d