package Event;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Event implements EventTypeInterface {
    private int id;
    //    EventTypeObject eventTypeObject;
    private Instant date;
    private String type;


//    public EventTypeObject getEventTypeObject() {
//        return eventTypeObject;
//    }

//    public void setEventTypeObject(EventTypeObject eventTypeObject) {
//        this.eventTypeObject = eventTypeObject;
//    }

    public Event() {
    }

    public Event(int id, Instant date, String type) {
        this.id = id;
        this.date = date;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", Date=" + date +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id && Objects.equals(date, event.date) && Objects.equals(type, event.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//TODO choose that it`s return?
//    @Override
//    public Instant getDate() {
//        return null;
//    }
//
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



