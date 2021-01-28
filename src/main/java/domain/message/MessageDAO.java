package domain.message;

import domain.DAO;
import domain.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

public class MessageDAO implements DAO<Message, Integer> {

    public MessageDAO() {

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
