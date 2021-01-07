package Event;

import Event.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.Instant;

public class ApplicationDemo {

    public static void main(String[] args) {

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();
            DAO<Event, Integer> eventDAO = new EventDAO(factory);

            final Event event = new Event(1, Instant.now(), "text");
//            final Event event = new Event();
//            event.setId(1);
//            event.setDate(null);
//            event.setType("testType");
//            eventDAO.create(event);
            eventDAO.create(event);
            final Event event2 = new Event(2, Instant.now(), "text");
            eventDAO.create(event);

            final Event result = eventDAO.read(1);
            System.out.println("Created : " + result);
            System.out.println();

            result.setType("54321");
            eventDAO.update(result);

            final Event update = eventDAO.read(1);
            System.out.println("Updated : " + update);
            System.out.println();

//            eventDAO.delete(new Event(1, Instant.now(), "54321"));
            eventDAO.delete(update);
            System.out.println("Deleted(empty obj) : " + eventDAO.read(1));
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}