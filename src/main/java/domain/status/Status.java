package domain.status;

import domain.project.Project;

import javax.persistence.*;

/**
 * @author Georgiy Minasian
 */
@Entity
@Table(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "title")
    String title;

    @JoinColumn(name = "project_id")
    Project project;

    public Status() {
    }

    public Status(String title, Project project) {
        this.title = title;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
