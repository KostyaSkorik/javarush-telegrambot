package com.github.javarushcommunity.javarush_telegrambot.command;

import static com.github.javarushcommunity.javarush_telegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;

public class UnknownCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return "/fdsfdsf";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
