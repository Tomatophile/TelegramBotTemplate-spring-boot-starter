package org.telegram.tomatophile.bottemplate.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.tomatophile.bottemplate.processed.callback.Callback;
import org.telegram.tomatophile.bottemplate.processed.command.Command;
import org.telegram.tomatophile.bottemplate.processed.text.Text;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProcessedConfig {
    @Bean
    public List<Command> commands(ApplicationContext applicationContext) {
        var commands = new ArrayList<Command>();
        var beanNames = applicationContext.getBeanNamesForType(Command.class);

        for (var name : beanNames) {
            commands.add((Command) applicationContext.getBean(name));
        }

        return commands;
    }

    @Bean
    public List<Text> texts(ApplicationContext applicationContext) {
        var textMessages = new ArrayList<Text>();
        var beanNames = applicationContext.getBeanNamesForType(Text.class);

        for(var name : beanNames){
            textMessages.add((Text) applicationContext.getBean(name));
        }

        return textMessages;
    }

    @Bean
    public List<Callback> callbacks(ApplicationContext applicationContext){
        var callbacks = new ArrayList<Callback>();
        var beanNames = applicationContext.getBeanNamesForType(Callback.class);

        for (var name : beanNames){
            callbacks.add((Callback) applicationContext.getBean(name));
        }

        return callbacks;
    }
}
