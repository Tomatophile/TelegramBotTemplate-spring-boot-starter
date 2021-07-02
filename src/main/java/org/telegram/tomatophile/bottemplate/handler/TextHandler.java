package org.telegram.tomatophile.bottemplate.handler;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.tomatophile.bottemplate.processed.text.Text;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class TextHandler implements UpdateHandler{
    private final List<Text> texts;

    public List<PartialBotApiMethod<Message>> handle(Update update) {
        var message = update.getMessage();

        for(var text : texts){
            if(message.getText().equals(text.getText())){
                return text.process(update);
            }
        }

        return new ArrayList<>();
    }

    @Override
    public boolean canHandle(Update update) {
        return update.hasMessage()&&update.getMessage().hasText()&&!update.getMessage().getText().startsWith("/");
    }
}
