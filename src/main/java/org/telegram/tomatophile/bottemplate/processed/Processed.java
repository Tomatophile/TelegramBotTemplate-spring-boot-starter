package org.telegram.tomatophile.bottemplate.processed;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public interface Processed {
    List<PartialBotApiMethod<Message>> process(Update update);
}
