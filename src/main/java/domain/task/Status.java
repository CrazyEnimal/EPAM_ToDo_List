package domain.task;

import domain.Member;
import domain.Project;

/**
 * @author Georgiy Minasian
 */
public class Status {
    int id;
    Member creator;
    Project[] projects;
    String title;
    Member executor;

    public Status() {
    }

    public Status(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
