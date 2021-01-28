package domain.event;

import domain.DAO;
import domain.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

public class EventDAO implements DAO<Event, Integer> {

    /**
     * Connection factory to database.
     */

    public EventDAO() {

    }

    /**
     * Create new event in events table.
     *
     * @param event for add.
     */
    @Override
    public void create(@NotNull final Event event) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
//        session.save(event);
        session.save(event);
        tx1.commit();
        session.close();
    }

    /**
     * Get engine by model.
     *
     * @param id for select.
     * @return engine with param model.
     */
    @Override
    public Event read(@NotNull final Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Event.class, id);
    }

    /**
     * Update engine state.
     *
     * @param event new state.
     */
    @Override
    public void update(@NotNull final Event event) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(event);
        tx1.commit();
        session.close();
    }

    /**
     * Delete engine.
     *
     * @param event for delete.
     */
    @Override
    public void delete(@NotNull final Event event) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(event);
        tx1.commit();
        session.close();
    }
}
