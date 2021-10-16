package org.bot.services;

public class EmptyService implements IServiceBot{


    @Override
    public TypeService getServiceType() {
        return TypeService.EMPTY_SERVICE;
    }

    @Override
    public String getMessageForUser() {
        return "";
    }

    @Override
    public String processUserMessage(String message) {
        return "call \\help to find out the capabilities of the bot";
    }
}
