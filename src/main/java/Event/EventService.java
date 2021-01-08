package Event;

import java.time.Instant;

public class EventService {
    private DAO<Event, Integer> eventDAO = new EventDAO();

    public EventService() {

    }

    public void create(Event event) {
        eventDAO.create(event);
    }

    public void update(Event event) {
        eventDAO.update(event);
    }

    public void delete(Event event) {
        eventDAO.delete(event);
    }

    public final Event read(int id) {
        return eventDAO.read(id);
    }
}
