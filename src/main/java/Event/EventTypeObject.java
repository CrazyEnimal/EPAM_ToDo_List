package Event;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class EventTypeObject implements EventTypeInterface {

    private Instant startDate;
    private Instant dueDate;
    private Instant creatingDate;
    private RepeatDate repeatDate;


    public Instant getStartDate () {
        return startDate;
    }

    public void setStartDate (Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getDueDate () {
        return dueDate;
    }

    public void setDueDate (Instant dueDate) {
        this.dueDate = dueDate;
    }

    public Instant getCreatingDate () {
        return creatingDate;
    }

    public EventTypeObject () {
    }

    public EventTypeObject (Instant creatingDate) {
        this.creatingDate = creatingDate;
        this.repeatDate = null;
    }

    public EventTypeObject (Instant startDate, Instant creatingDate) {
        this(creatingDate);
        this.startDate = startDate;
        this.repeatDate = null;
    }

    public EventTypeObject (Instant startDate, Instant dueDate, Instant creatingDate) {
        this(startDate, creatingDate);
        this.dueDate = dueDate;
        this.repeatDate = null;
    }

    //TODO:
    // choose correct/best constructor

    public EventTypeObject (Instant startDate, Instant dueDate, Instant creatingDate, int count, String period) {
        this(startDate, creatingDate, dueDate);
        this.repeatDate = new RepeatDate(count, RepeatDate.Period.valueOf(period));
    }

    public EventTypeObject (Instant startDate, Instant dueDate, Instant creatingDate, RepeatDate repeatDate) {
        this(startDate, creatingDate, dueDate);
        this.repeatDate = repeatDate;
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
        EventTypeObject that = (EventTypeObject) o;
        return Objects.equals(startDate, that.startDate) && Objects.equals(dueDate, that.dueDate) && Objects.equals(creatingDate, that.creatingDate) && Objects.equals(repeatDate, that.repeatDate);
    }

    @Override
    public int hashCode () {
        return Objects.hash(startDate, dueDate, creatingDate, repeatDate);
    }

    @Override
    public String toString () {
        return "EventTypeObject{" +
                "startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", creatingDate=" + creatingDate +
                ", repeatDate=" + repeatDate +
                '}';
    }

    public static class RepeatDate {
        public RepeatDate (int count, Period period) {
            this.count = count;
        }

        private int count;

        private enum Period {

            DAY("DAY"), WEEK("WEEK"), MONTHS("MONTHS"), QUARTER("QUARTER"), YEAR("YEAR");
            private String day;

            Period (String day) {
                this.day = day;
            }

            public String getDay () {
                return day;
            }
        }
    }
}
//TODO:
////класс
////    /*
////        Общий вид описания класса Объект События.
////        Омплементирует в себя интерфейс.
////        в поле тип, описываются разные реализации объектов.
////    */
////        "eventTypeObject" : {
//		"implements" : eventTypeInteface,
//        "type" : extended {
//         //дата окончания
//		 dueDate : { "date" : Instant },
//            //повтор ивента:каждый ///
//			repeateDate : {
//			"date" : Instant,
//                "startRepeatingDate" : Instant,
//                "period" : enum(DAY, WEAK, MONTHS, CVARTER, YEAR)
//                },
///////////////// class RepeatDate -> затем будем проверять обект класса -> !=null ->
//        -> создается через for цепочка event`ов как в Google Calendar c добавлением нужной даты по Instant.plus()
//        от даты старта ивента;
//            //дата начала
//			startDate : { "date" : Instant }
//        }
//    }
////
