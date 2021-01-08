package Event;

import Event.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.Instant;

public class ApplicationDemo {

    public static void main(String[] args) {


        EventService eventService = new EventService();
        final Event event = new Event(1, Instant.now(), "text");
        eventService.create(event);
        final Event event2 = new Event(2, Instant.now(), "text2");
        eventService.create(event2);

        final Event result = eventService.read(1);
        System.out.println("Created : " + result);
        System.out.println();

        result.setType("54321");
        eventService.update(result);

        final Event update = eventService.read(1);
        System.out.println("Updated : " + update);
        System.out.println();

//          eventDAO.delete(new Event(1, Instant.now(), "54321"));
        eventService.delete(update);
        System.out.println("Deleted(empty obj) : " + eventService.read(1));

    }
}