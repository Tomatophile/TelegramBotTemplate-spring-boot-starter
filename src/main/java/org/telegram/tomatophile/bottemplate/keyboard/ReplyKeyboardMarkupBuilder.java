package org.telegram.tomatophile.bottemplate.keyboard;

import lombok.Setter;
import lombok.experimental.Accessors;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
public class ReplyKeyboardMarkupBuilder implements KeyboardMarkupBuilder{
    @Setter
    private String chatId;
    @Setter
    private String text;

    private final List<KeyboardRow> keyboard = new ArrayList<>();
    private KeyboardRow row;

    private ReplyKeyboardMarkupBuilder() {
        row = new KeyboardRow();
        keyboard.add(row);
    }

    public static ReplyKeyboardMarkupBuilder create(String chatId) {
        return new ReplyKeyboardMarkupBuilder().setChatId(chatId);
    }

    public ReplyKeyboardMarkupBuilder addButton(String text) {
        row.add(text);
        return this;
    }

    @Override
    public ReplyKeyboardMarkupBuilder nextRow() {
        row = new KeyboardRow();
        keyboard.add(row);
        return this;
    }

    @Override
    public SendMessage build() {
        var message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        var keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);
        keyboardMarkup.setKeyboard(keyboard);

        message.setReplyMarkup(keyboardMarkup);
        return message;
    }
}
