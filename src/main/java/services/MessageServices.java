package services;

import dao.MessageDAO;
import models.Message;

import java.util.List;

public class MessageServices {

    private MessageDAO messageDAO;

    public MessageServices() {
    }

    public Message find(int id) {
        return messageDAO.findById(id);
    }

    public void save(Message message){
        messageDAO.save(message);
    }

    public void update(Message message){
        messageDAO.update(message);
    }

    public void delete(Message message){
        messageDAO.delete(message);
    }

    public List<Message> findAll() {
        return messageDAO.findAll();
    }
}
