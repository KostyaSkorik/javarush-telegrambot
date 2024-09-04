FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test1_javarush_community_bot
ENV BOT_TOKEN=7346773484:AAGr02mPN7L7P10DQNuLNmmx52ZU07xH2hE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.username=${BOT_NAME}","-Dbot.token=${BOT_TOKEN}","-jar","/app.jar"]