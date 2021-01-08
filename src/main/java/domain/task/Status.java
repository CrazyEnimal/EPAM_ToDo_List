package domain.task;

import domain.Project;

import javax.persistence.*;

/**
 * @author Georgiy Minasian
 */
@Entity
@Table(name = "Statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "Title")
    String title;

    @OneToOne
    @JoinColumn(name = "ProjectId")
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
