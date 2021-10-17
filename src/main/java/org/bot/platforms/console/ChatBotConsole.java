package org.bot.platforms.console;

import org.bot.platforms.ChatPlatform;

import java.util.Scanner;

import static java.lang.System.out;

public class ChatBotConsole implements ChatPlatform<String, String> {

    @Override
    public void inputMessage(String message) {
        out.println(message);
    }

    @Override
    public String outputMessage() {
        var inputReader = new Scanner(System.in);
        return inputReader.nextLine();
    }
}
