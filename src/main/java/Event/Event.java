package Event;

import java.util.Date;

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

    public Event (int id, EventTypeObject eventTypeObject) {
        this.id = id;
        this.eventTypeObject = eventTypeObject;
    }

    @Override
    public Date getDate () {
        return null;
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



