package dao;

import models.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class MessageDAO {
    public Message findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Message.class, id);
    }

    public void save(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(message);
        tx1.commit();
        session.close();
    }

    public void update(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(message);
        tx1.commit();
        session.close();
    }

    public void delete(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(message);
        tx1.commit();
        session.close();
    }

    public List<Message> findAll() {
        List<Message> messages = (List<Message>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Message").list();
        return messages;
    }
}
