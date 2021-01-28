package dao;

import models.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TaskDAO {
    public Task findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Task task = session.get(Task.class, id);

        return task;
    }

    public void save(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(task);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(task);
        session.getTransaction().commit();
        session.close();
    }

    public List<Task> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Task> tasks = (List<Task>) session.createQuery("From Task").list();

        return tasks;
    }
}
