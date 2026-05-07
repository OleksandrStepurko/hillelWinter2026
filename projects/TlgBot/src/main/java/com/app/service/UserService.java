package com.app.service;

import com.app.entity.User;
import com.app.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void createUser(Message msg){
        var chatId = msg.getChatId().toString();
        if (repository.getUserByChatId(chatId).isEmpty()){
            User user = new User()
                .setChatId(chatId)
                .setName(msg.getFrom().getLastName() + " " + msg.getFrom().getFirstName())
                .setTlgName(msg.getFrom().getUserName());

            repository.save(user);
        }
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

}
