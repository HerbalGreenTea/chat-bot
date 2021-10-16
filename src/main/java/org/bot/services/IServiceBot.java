package org.bot.services;

public interface IServiceBot {
    TypeService getServiceType();
    String getMessageForUser();
    String processUserMessage(String message);
}
