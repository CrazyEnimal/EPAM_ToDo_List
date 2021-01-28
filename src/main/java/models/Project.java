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

    @ManyToOne
    @JoinColumn(name="creator_id")
    private Member creator;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Member supervisor;

    @Column(name = "title")
    private String title;

    @OneToMany
    @JoinTable(name="projects_followers",
            joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns = @JoinColumn(name="member_id", unique=true))
    private List<Member> projectFollowers;

    @OneToMany
    @JoinTable(name="projects_tasks",
            joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns = @JoinColumn(name="task_id", unique=true))
    private List<Task> projectTasks;

    public Project(){}

    public Project(Member creator, String title) {
        this.creator = creator;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public Member getCreator() {
        return creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public Member getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Member supervisor) {
        this.supervisor = supervisor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Member> getFolowers() {
        return projectFollowers;
    }

    public List<Task> getTasks() {
        return projectTasks;
    }

    public void addFolower(Member member) {
        projectFollowers.add(member);
    }

    public void addTasks(Task task) {
        projectTasks.add(task);
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
