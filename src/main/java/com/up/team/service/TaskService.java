package com.up.team.service;

import com.up.team.entity.Task;

public interface TaskService {

    void create(Task task);

    void update(Task task);

    void delete(Task task);

    Task read(int id);
}
