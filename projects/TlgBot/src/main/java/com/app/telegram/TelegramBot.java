package com.app.telegram;

import com.app.entity.User;
import com.app.service.UserService;
import java.io.File;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final UserService userService;

    @Value("${telegram.bot.username}")
    private String username;

    @Value("${telegram.bot.token}")
    private String token;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long id = update.getMessage().getFrom().getId();
            String name = update.getMessage().getFrom().getUserName();
            log.info("Received message from {} >> {}: {}", id, name, text);

            Message msg = update.getMessage();
//            if (text.equals("/start")){
//                userService.createUser(msg);
//            } else if (text.startsWith("/all")){
//                sendMessageForAll(text.replace("/all", "").trim());
//            }else if (text.startsWith("/photo")){
//                sendPhotoToAllUsers();
//            } else {
//                showUi(msg.getChatId());
//            }

            if (update.hasCallbackQuery()) {
                CallbackQuery callback = update.getCallbackQuery();
                String data = callback.getData();
                if ("SEND_HELLO".equals(data)) {
                    sendMessageForAll("Привет медвед...");
                }
            } else {
                showUi(msg.getChatId());
            }
        }
    }

    private void showUi(Long chatId) {
        SendMessage msg = new SendMessage(chatId.toString(),
            "Выберите действие:");
        msg.setReplyMarkup(mainKeyboard());
        executeSend(msg);
    }

    private InlineKeyboardMarkup mainKeyboard() {
        InlineKeyboardButton btnSend = new InlineKeyboardButton("🚀 Отправить всем привет");
        btnSend.setCallbackData("SEND_HELLO");

        List<List<InlineKeyboardButton>> rows = List.of(
            List.of(btnSend)
        );
        InlineKeyboardMarkup kb = new InlineKeyboardMarkup();
        kb.setKeyboard(rows);
        return kb;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public void sendMessageForAll(String message) {
        for (User user : userService.getAllUsers()) {
            SendMessage sMsg = new SendMessage();
            sMsg.setChatId(user.getChatId());
            sMsg.setText(message);
            executeSend(sMsg);
        }
    }

    private void executeSend(BotApiMethodMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public void sendPhotoToAllUsers() {
        for (User user : userService.getAllUsers()) {
            sendPhoto(Long.parseLong(user.getChatId()));
        }
    }

    @SneakyThrows
    public void sendPhotoFromUrlToAllUsers(String url) {
        for (User user : userService.getAllUsers()) {
            sendPhotoFromUrl(Long.parseLong(user.getChatId()), url);
        }
    }

    private void sendPhoto(Long chatId) throws TelegramApiException {
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId.toString());
        InputFile inputFile = new InputFile(new File(
            "/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/projects/TlgBot/src/main/resources/IMG_6930.jpg"));
        photo.setPhoto(inputFile);
        photo.setCaption("test photo");
        execute(photo);
    }

    private void sendPhotoFromUrl(Long chatId, String url) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId.toString());

        InputFile file = new InputFile();
        file.setMedia(url);
        sendPhoto.setPhoto(file);
        sendPhoto.setCaption("Фото по URL");

        execute(sendPhoto);
    }

}
