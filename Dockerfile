FROM openjdk:17
ARG JAR_FILE=target/*.jar
ENV BOT_NAME="test1_javarush_community_bot"
ENV BOT_TOKEN="7346773484:AAGr02mPN7L7P10DQNuLNmmx52ZU07xH2hE"
ENV BOT_DB_USERNAME="root"
ENV BOT_DB_PASSWORD="Ka2004-skor"
ENV DB_URL = "jdbc:mysql://jrtb-db:3306/jrtb_db"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}","-Dspring.datasource.url=${DB_URL}","-jar", "app.jar"]



