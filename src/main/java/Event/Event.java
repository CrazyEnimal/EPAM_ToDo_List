package Event;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Event implements EventTypeInterface{
    private int id;
    EventTypeObject eventTypeObject;

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public EventTypeObject getEventTypeObject () {
        return eventTypeObject;
    }

    public void setEventTypeObject (EventTypeObject eventTypeObject) {
        this.eventTypeObject = eventTypeObject;
    }

    public Event () {
    }

    public Event (int id, EventTypeObject eventTypeObject) {
        this.id = id;
        this.eventTypeObject = eventTypeObject;
    }
//TODO choose that it`s return?
    @Override
    public Instant getDate () {
        return null;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id && Objects.equals(eventTypeObject, event.eventTypeObject);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, eventTypeObject);
    }

    @Override
    public String toString () {
        return "Event{" +
                "id=" + id +
                ", eventTypeObject=" + eventTypeObject +
                '}';
    }
}


//TODO

////просто класс
//    /*
//        Собитие, как сообщалось ранее описывается интерфейсом.
//    */
//    "event" : {
//        *"id" : Int,
//        "type" : eventTypeobject,
//    },
// решить что будет тут возвр гет дейт
//



