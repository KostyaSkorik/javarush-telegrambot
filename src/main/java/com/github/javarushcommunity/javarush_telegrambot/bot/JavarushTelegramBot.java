package com.github.javarushcommunity.javarush_telegrambot.bot;

import com.github.javarushcommunity.javarush_telegrambot.command.CommandContainer;
import com.github.javarushcommunity.javarush_telegrambot.service.SendBotMessageServiceImpl;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import static com.github.javarushcommunity.javarush_telegrambot.command.CommandName.*;


/*
Разобраться с тем, что не отображаются поля при регистрации бота, и геттеры выдают null
 */
@Component
public class JavarushTelegramBot extends TelegramLongPollingBot {
    private String username = "test1_javarush_community_bot";
    private String token = "7346773484:AAGr02mPN7L7P10DQNuLNmmx52ZU07xH2hE" ;

    private final CommandContainer commandContainer;




    public void registr() throws TelegramApiException{
        //Регистрация бота
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(this);
        }
        catch (TelegramApiException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
    @Autowired
    public JavarushTelegramBot(TelegramUserService telegramUserService) throws TelegramApiException {
        registr();
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this),telegramUserService);

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
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
