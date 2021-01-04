package models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorId")
    private Member creator;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SupervisorId")
    private Member supervisor;

    @Column(name = "Title")
    private String title;

    @OneToMany(mappedBy = "project_folowers", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectFolower> projectFolowers;

    @OneToMany(mappedBy = "projects_tasks", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectTask> projectTasks;

    public Project(){}

    public Project(Member creator, String title) {
        this.creator = creator;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    private Member getCreator() {
        return creator;
    }

    private void setCreator(Member creator) {
        this.creator = creator;
    }

    private Member getSupervisor() {
        return supervisor;
    }

    private void setSupervisor(Member supervisor) {
        this.supervisor = supervisor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", creator=" + creator.toString() +
                ", supervisor=" + supervisor.toString() +
                ", title='" + title + '\'' +
                '}';
    }
}
