package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.javarushcommunity.javarush_telegrambot.command.CommandName.*;

public class HelpCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    public static final String HELP_MESSAGE = String.format("""
                    ✨<b>Дотупные команды</b>✨

                    <b>Начать\\закончить работу с ботом</b>
                    %s - начать работу со мной
                    %s - приостановить работу со мной

                    %s - получить помощь в работе со мной
                    %s - получить статистику пользователей
                    
                    """,
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName(),STAT.getCommandName());
    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);

    }

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }
}
