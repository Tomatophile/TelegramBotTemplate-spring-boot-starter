package org.telegram.tomatophile.bottemplate.handler;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public interface UpdateHandler {
    /**
     * Handle received update and return list of PartialBotApiMethod with message if process is found
     * else return empty list
     * */
    List<PartialBotApiMethod<Message>> handle(Update update);

    boolean canHandle(Update update);
}
