package org.telegram.tomatophile.bottemplate.receiver;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.tomatophile.bottemplate.handler.UpdateHandler;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UpdateReceiver {
    private final List<UpdateHandler> updateHandlers;

    public List<PartialBotApiMethod<Message>> receive(Update update){
        for(var updateHandler : updateHandlers){
            if(updateHandler.canHandle(update)){
                return updateHandler.handle(update);
            }
        }

        return new ArrayList<>();
    }
}
