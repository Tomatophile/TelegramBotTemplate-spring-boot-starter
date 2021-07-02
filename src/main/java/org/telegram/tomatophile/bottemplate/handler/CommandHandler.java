package org.telegram.tomatophile.bottemplate.handler;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.tomatophile.bottemplate.processed.command.Command;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CommandHandler implements UpdateHandler{
    private final List<Command> commands;

    public List<PartialBotApiMethod<Message>> handle(Update update) {
        var message = update.getMessage();

        for(var command : commands){
            if(message.getText().startsWith(command.getCommand())){
                return command.process(update);
            }
        }

        return new ArrayList<>();
    }

    @Override
    public boolean canHandle(Update update) {
        return update.hasMessage()&&update.getMessage().hasText()&&update.getMessage().getText().startsWith("/");
    }
}
