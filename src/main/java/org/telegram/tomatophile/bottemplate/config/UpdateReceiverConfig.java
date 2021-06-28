package org.telegram.tomatophile.bottemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.tomatophile.bottemplate.handler.UpdateHandler;
import org.telegram.tomatophile.bottemplate.receiver.UpdateReceiver;

import java.util.List;

@Configuration
public class UpdateReceiverConfig {
    @Bean
    public UpdateReceiver updateReceiver(List<UpdateHandler> updateHandlers){
        return new UpdateReceiver(updateHandlers);
    }
}
