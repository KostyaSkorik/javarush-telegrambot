package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE = "Привет. Я Javarush Telegram Bot. Я помогу тебе быть в курсе последних " +
            "статей тех авторов, котрые тебе интересны. Я еще маленький и только учусь.";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(String.valueOf(update.getMessage().getChatId()),START_MESSAGE);
    }
}
