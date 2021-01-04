package Event;

import java.time.Instant;
import java.util.Date;

public interface EventTypeInterface {
    Instant getDate ();
}
//TODO:
////интерфейс
//    /*
//        Реализация интерфейса события, по идее нужна только дата,
//        которая будет отображаться в таске, но т.к. события могут иметь и другой функционал,
//        для создани янпоминалок например, то это будет оговоариваться отдельно.
//    */
//    "eventTypeInterface" : {
//            "methods" : {
//            getDate();
//            }
//            },
//
