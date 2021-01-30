package com.up.team.dao;

import com.up.team.HibernateSessionFactoryUtil;
import com.up.team.entity.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public class MessageDaoImpl implements DAO<Message, Integer> {

    public MessageDaoImpl() {

    }

    @Override
    public void create(@NotNull final Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(message);
        tx1.commit();
        session.close();
    }

    @Override
    public Message read(@NotNull final Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Message.class, id);
    }

    @Override
    public void update(@NotNull final Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(message);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(@NotNull final Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(message);
        tx1.commit();
        session.close();
    }
}
