package Event;


import javax.persistence.*;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {
    @Id
    private int id;
    //    EventTypeObject eventTypeObject;
    @Column(name = "Date")
    private Instant date;
    @Column(name = "Type")
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
    }}



