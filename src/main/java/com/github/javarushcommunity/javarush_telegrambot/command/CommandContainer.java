package com.github.javarushcommunity.javarush_telegrambot.command;
import com.github.javarushcommunity.javarush_telegrambot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.javarushcommunity.javarush_telegrambot.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String,Command> commandMap;
    /*
    ImmutableMap — это тип карты в Java, который является неизменяемым.
    Это означает, что содержимое карты является фиксированным или
    постоянным после объявления, то есть оно доступно только для чтения.
    Если попытаться добавить, удалить или обновить элементы в карте,
    будет выброшено исключение UnsupportedOperationException.
     */

    private final Command unknownCommand;
    public CommandContainer(SendBotMessageService sendBotMessageService){
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(),new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(),new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(),new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(),new NoCommand(sendBotMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    /*
       Передаем в метод конкретную комманду и выносим значение
       по ключу из неизменяемой мапы, иначе используем
       дефолтное значение, а именно unknownCommand.
    */
    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier,unknownCommand);
    }

}
