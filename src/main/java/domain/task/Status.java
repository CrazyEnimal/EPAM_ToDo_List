package domain.task;

import domain.Project;

/**
 * @author Georgiy Minasian
 */
public class Status {
    int id;
    String title;
    Project project;

    public Status() {
    }

    public Status(int id) {
        this.id = id;
    }

    public Status(int id, String title, Project project) {
        this.id = id;
        this.title = title;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
