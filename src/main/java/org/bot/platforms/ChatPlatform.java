package org.bot.platforms;

public interface ChatPlatform<INPUT_TYPE, OUTPUT_TYPE> {
    void inputMessage(INPUT_TYPE message);

    OUTPUT_TYPE outputMessage();
}
