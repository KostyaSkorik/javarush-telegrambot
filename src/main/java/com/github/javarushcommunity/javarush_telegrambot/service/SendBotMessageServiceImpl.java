package com.github.javarushcommunity.javarush_telegrambot.service;

import com.github.javarushcommunity.javarush_telegrambot.bot.JavarushTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{
    private final JavarushTelegramBot javarushbot;

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            javarushbot.execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    @Autowired
    public SendBotMessageServiceImpl(JavarushTelegramBot javarushbot) {
        this.javarushbot = javarushbot;
    }
}
