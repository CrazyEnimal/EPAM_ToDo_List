package com.up.team.service;


import com.up.team.dao.DAO;
import com.up.team.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

        @Autowired
        private DAO<Task, Integer> taskDAO;

        @Override
        public void create(Task task) {
            taskDAO.create(task);
        }

        @Override
        public void update(Task task) {
            taskDAO.update(task);
        }

        @Override
        public void delete(Task task) {
            taskDAO.delete(task);
        }

        @Override
        public final Task read(int id) {
            return taskDAO.read(id);
        }
}
