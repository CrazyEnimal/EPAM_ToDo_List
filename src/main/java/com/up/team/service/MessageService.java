package com.up.team.service;


import com.up.team.dao.DAO;
import com.up.team.dao.MessageDao;
import com.up.team.entity.Message;

public class MessageService {
    private final DAO<Message, Integer> messageDAO = new MessageDao();

    public MessageService() {

    }

    public void create(Message message) {
        messageDAO.create(message);
    }

    public void update(Message message) {
        messageDAO.update(message);
    }

    public void delete(Message message) {
        messageDAO.delete(message);
    }

    public final Message read(int id) {
        return messageDAO.read(id);
    }
}