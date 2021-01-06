package dao;

import models.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TaskDAO {
    public Task findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Task.class, id);
    }

    public void save(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(task);
        tx1.commit();
        session.close();
    }

    public void update(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(task);
        tx1.commit();
        session.close();
    }

    public void delete(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(task);
        tx1.commit();
        session.close();
    }

    public List<Task> findAll() {
        List<Task> tasks = (List<Task>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Task").list();
        return tasks;
    }
}
