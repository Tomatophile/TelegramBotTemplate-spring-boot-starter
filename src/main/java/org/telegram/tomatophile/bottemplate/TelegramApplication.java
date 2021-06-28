package org.telegram.tomatophile.bottemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class TelegramApplication {
    private TelegramApplication(){}

    public static ConfigurableApplicationContext run(Class<?> mainClass, String... args){
        return SpringApplication.run(mainClass, args);
    }
}
