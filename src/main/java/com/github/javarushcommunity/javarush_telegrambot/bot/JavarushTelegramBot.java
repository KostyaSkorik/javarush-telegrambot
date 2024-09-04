package com.github.javarushcommunity.javarush_telegrambot.bot;

import com.github.javarushcommunity.javarush_telegrambot.command.CommandContainer;
import com.github.javarushcommunity.javarush_telegrambot.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.javarushcommunity.javarush_telegrambot.command.CommandName.*;



@Component
public class JavarushTelegramBot extends TelegramLongPollingBot {

    @Value(value = "${bot.username}")
    private String botUsername;
    @Value(value = "${bot.token}")
    private String botToken;

    private final CommandContainer commandContainer;

    public JavarushTelegramBot(){
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));

    }


    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String COMMAND_PREFIX = "/";
            if (message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            }else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
