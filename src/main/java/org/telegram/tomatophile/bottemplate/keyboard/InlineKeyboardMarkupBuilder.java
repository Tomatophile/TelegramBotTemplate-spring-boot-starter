package org.telegram.tomatophile.bottemplate.keyboard;

import lombok.Setter;
import lombok.experimental.Accessors;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
public class InlineKeyboardMarkupBuilder implements KeyboardMarkupBuilder{
    @Setter
    private String chatId;
    @Setter
    private String text;

    private final List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
    private List<InlineKeyboardButton> row;

    private InlineKeyboardMarkupBuilder() {
        row = new ArrayList<>();
        keyboard.add(row);
    }

    public static InlineKeyboardMarkupBuilder create(String chatId){
        return new InlineKeyboardMarkupBuilder().setChatId(chatId);
    }

    public InlineKeyboardMarkupBuilder addButton(String text, String callbackData){
        var button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(callbackData);
        row.add(button);
        return this;
    }

    public InlineKeyboardMarkupBuilder addButton(String text, URL url) {
        var button = new InlineKeyboardButton();
        button.setText(text);
        button.setUrl(url.toString());
        row.add(button);
        return this;
    }

    public InlineKeyboardMarkupBuilder addButton(String text, String callbackData, URL url) {
        var button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(callbackData);
        button.setUrl(url.toString());
        row.add(button);
        return this;
    }

    @Override
    public InlineKeyboardMarkupBuilder nextRow(){
        row = new ArrayList<>();
        keyboard.add(row);
        return this;
    }

    @Override
    public SendMessage build() {
        var message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        var keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboard);

        message.setReplyMarkup(keyboardMarkup);
        return message;
    }
}
