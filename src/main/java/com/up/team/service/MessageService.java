package com.up.team.service;

import com.up.team.entity.Message;

public interface MessageService {

    void create(Message message);

    void update(Message message);

    void delete(Message message);

    Message read(int id);
}
