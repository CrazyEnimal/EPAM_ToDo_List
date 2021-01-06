package dao;

import models.TaskMessage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TaskMessageDAO {
    public TaskMessage findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TaskMessage.class, id);
    }

    public void save(TaskMessage taskMessage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(taskMessage);
        tx1.commit();
        session.close();
    }

    public void update(TaskMessage taskMessage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(taskMessage);
        tx1.commit();
        session.close();
    }

    public void delete(TaskMessage taskMessage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(taskMessage);
        tx1.commit();
        session.close();
    }

    public List<TaskMessage> findAll() {
        List<TaskMessage> taskMessages = (List<TaskMessage>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From TaskMessage").list();
        return taskMessages;
    }
}
