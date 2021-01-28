package com.up.team.service;


import com.up.team.dao.DAO;
import com.up.team.dao.TaskDao;
import com.up.team.entity.Task;

public class TaskService {
        private DAO<Task, Integer> taskDAO = new TaskDao();

        public TaskService() {

        }

        public void create(Task task) {
            taskDAO.create(task);
        }

        public void update(Task task) {
            taskDAO.update(task);
        }

        public void delete(Task task) {
            taskDAO.delete(task);
        }

        public final Task read(int id) {
            return taskDAO.read(id);
        }
}
