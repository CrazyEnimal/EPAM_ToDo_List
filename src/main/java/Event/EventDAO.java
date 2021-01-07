package Event;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;

public class EventDAO implements DAO<Event, Integer>{

    /**
     * Connection factory to database.
     */
    private final SessionFactory factory;

    public EventDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Create new event in events table.
     *
     * @param event for add.
     */
    @Override
    public void create(@NotNull final Event event) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.saveOrUpdate(event);
//            session.save(event);

            session.getTransaction().commit();
        }
    }

    /**
     * Get engine by model.
     *
     * @param id for select.
     * @return engine with param model.
     */
    @Override
    public Event read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {

            final Event result = session.get(Event.class, id);

            return result != null ? result : new Event();
        }
    }

    /**
     * Update engine state.
     *
     * @param event new state.
     */
    @Override
    public void update(@NotNull final Event event) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(event);

            session.getTransaction().commit();
        }
    }

    /**
     * Delete engine.
     *
     * @param event for delete.
     */
    @Override
    public void delete(@NotNull final Event event) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(event);

            session.getTransaction().commit();
        }
    }
}
