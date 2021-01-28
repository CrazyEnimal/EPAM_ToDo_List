package domain.status;

import domain.DAO;
import domain.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

public class StatusDAO implements DAO<Status, Integer> {

    public StatusDAO() {

    }

    @Override
    public void create(@NotNull final Status status) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(status);
        tx.commit();
        session.close();
    }

    @Override
    public Status read(@NotNull final Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Status.class, id);
    }

    @Override
    public void update(@NotNull final Status status) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(status);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(@NotNull final Status status) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(status);
        tx.commit();
        session.close();
    }
}
