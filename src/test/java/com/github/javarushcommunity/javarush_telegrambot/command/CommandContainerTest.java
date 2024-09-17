package com.github.javarushcommunity.javarush_telegrambot.command;


import com.github.javarushcommunity.javarush_telegrambot.service.SendBotMessageService;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init(){
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        commandContainer = new CommandContainer(sendBotMessageService,telegramUserService);
    }

    @Test
    public void shouldGetAllTheExistingCommands(){
        /*
         Тест опирается на логику работы контейнера. Все команды,
         которые поддерживает бот, находятся в списке CommandName
         и должны быть в контейнере. Поэтому я взял все переменные CommandName,
         перешел в Stream API и для каждого выполнил поиск команды из контейнера.
         Если бы такой команды не было, была бы возвращена команда UnknownCommand.
         Это мы и проверяем в этой строке 39
         */

        //when-then
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class,command.getClass());
                });
    }
    @Test
    public void shouldReturnUnknownCommand(){
        //given
        String unknownCommand = "/fdsfdsf";

        //when
        Command command = commandContainer.retrieveCommand(unknownCommand);

        //then(Проверяем то, что command будем UnknownCommand)
        Assertions.assertEquals(UnknownCommand.class,command.getClass());

    }
}
