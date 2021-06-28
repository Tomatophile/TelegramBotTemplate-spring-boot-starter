package org.telegram.tomatophile.bottemplate.handler;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.tomatophile.bottemplate.processed.callback.Callback;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CallbackQueryHandler implements UpdateHandler{
    private final List<Callback> callbacks;

    @Override
    public List<PartialBotApiMethod<Message>> handle(Update update) {
        var callbackQuery = update.getCallbackQuery();

        for(var callback : callbacks){
            if(callback.getData().equals(callbackQuery.getData())){
                return callback.process(callbackQuery.getMessage().getChatId().toString());
            }
        }

        return new ArrayList<>();
    }

    @Override
    public boolean canHandle(Update update) {
        return update.hasCallbackQuery();
    }
}
