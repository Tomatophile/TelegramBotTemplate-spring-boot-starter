package org.telegram.tomatophile.bottemplate.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.tomatophile.bottemplate.handler.CallbackQueryHandler;
import org.telegram.tomatophile.bottemplate.handler.CommandHandler;
import org.telegram.tomatophile.bottemplate.handler.TextHandler;
import org.telegram.tomatophile.bottemplate.handler.UpdateHandler;
import org.telegram.tomatophile.bottemplate.processed.callback.Callback;
import org.telegram.tomatophile.bottemplate.processed.command.Command;
import org.telegram.tomatophile.bottemplate.processed.text.Text;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UpdateHandlerConfig {
    @Bean
    public CallbackQueryHandler callbackQueryHandler(List<Callback> callbacks){
        return new CallbackQueryHandler(callbacks);
    }
    @Bean
    public CommandHandler commandHandler(List<Command> commands){
        return new CommandHandler(commands);
    }
    @Bean
    public TextHandler textHandler(List<Text> texts){
        return new TextHandler(texts);
    }

    @Bean
    public List<UpdateHandler> updateHandlers(ApplicationContext applicationContext){
        var updateHandlers = new ArrayList<UpdateHandler>();
        var beanNames = applicationContext.getBeanNamesForType(UpdateHandler.class);

        for (var name : beanNames) {
            updateHandlers.add((UpdateHandler) applicationContext.getBean(name));
        }

        return updateHandlers;
    }
}
