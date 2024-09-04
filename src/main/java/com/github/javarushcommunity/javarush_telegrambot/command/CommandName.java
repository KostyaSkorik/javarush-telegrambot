package com.github.javarushcommunity.javarush_telegrambot.command;

public enum CommandName {
    START("/start"),
    HELP("/help"),
    STOP("/stop"),
    NO("/no");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
