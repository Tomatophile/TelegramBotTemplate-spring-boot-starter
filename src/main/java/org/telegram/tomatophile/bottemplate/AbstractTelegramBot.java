package org.telegram.tomatophile.bottemplate;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.tomatophile.bottemplate.receiver.UpdateReceiver;

@RequiredArgsConstructor
public abstract class AbstractTelegramBot extends TelegramLongPollingBot {
    private final UpdateReceiver updateReceiver;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        var responseToUser = updateReceiver.receive(update);

        for (var send : responseToUser){
            if(send instanceof SendAnimation){
                execute((SendAnimation) send);
            } else if(send instanceof SendAudio){
                execute((SendAudio) send);
            } else if(send instanceof SendContact){
                execute((SendContact) send);
            } else if(send instanceof SendDice){
                execute((SendDice) send);
            } else if(send instanceof SendDocument){
                execute((SendDocument) send);
            } else if(send instanceof SendGame){
                execute((SendGame) send);
            } else if(send instanceof SendInvoice){
                execute((SendInvoice) send);
            } else if(send instanceof SendLocation){
                execute((SendLocation) send);
            } else if(send instanceof SendMessage){
                execute((SendMessage) send);
            } else if(send instanceof SendPhoto){
                execute((SendPhoto) send);
            } else if(send instanceof SendSticker){
                execute((SendSticker) send);
            } else if(send instanceof SendVenue){
                execute((SendVenue) send);
            } else if(send instanceof SendVideo){
                execute((SendVideo) send);
            } else if(send instanceof SendVoice){
                execute((SendVoice) send);
            }
        }
    }
}
