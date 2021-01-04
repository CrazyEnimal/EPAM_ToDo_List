package models;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CreatorId")
    private int creatorId;

    @Column(name = "SupervisorId")
    private int supervisorId;

    @Column(name = "Title")
    private String title;

    public Project(){}

    public Project(int creatorId, String title) {
        this.creatorId = creatorId;
        this.title = title;
    }



    public int getId() {
        return id;
    }
}
