package com.up.team.service;


import com.up.team.dao.DAO;
import com.up.team.dao.MessageDaoImpl;
import com.up.team.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private DAO<Message, Integer> messageDAO;

    public MessageServiceImpl() {

    }

    @Override
    public void create(Message message) {
        messageDAO.create(message);
    }

    @Override
    public void update(Message message) {
        messageDAO.update(message);
    }

    @Override
    public void delete(Message message) {
        messageDAO.delete(message);
    }

    @Override
    public final Message read(int id) {
        return messageDAO.read(id);
    }
}