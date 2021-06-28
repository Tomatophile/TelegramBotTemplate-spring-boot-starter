package org.telegram.tomatophile.bottemplate.keyboard;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface KeyboardMarkupBuilder {
    KeyboardMarkupBuilder setChatId(String chatId);

    KeyboardMarkupBuilder setText(String text);

    KeyboardMarkupBuilder nextRow();

    PartialBotApiMethod<Message> build();
}
