package domain.task;

import domain.DAO;
import domain.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

public class TaskDAO implements DAO<Task, Integer> {

    public TaskDAO() {

    }

    @Override
    public void create(@NotNull final Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(task);
        tx1.commit();
        session.close();
    }

    @Override
    public Task read(@NotNull final Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Task.class, id);
    }

    @Override
    public void update(@NotNull final Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(task);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(@NotNull final Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(task);
        tx1.commit();
        session.close();
    }
}
