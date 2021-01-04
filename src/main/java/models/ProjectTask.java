package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projects_tasks")
public class ProjectTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProjectId")
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TaskId")
    private Task task;

    public ProjectTask() {

    }

    public ProjectTask(Project project, Task task) {
        this.project = project;
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return id == that.id;
    }

    public int getId() {
        return id;
    }

    private Project getProject() {
        return project;
    }

    private void setProject(Project project) {
        this.project = project;
    }

    private Task getTask() {
        return task;
    }

    private void setTask(Task task) {
        this.task = task;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                "id=" + id +
                ", project=" + project.toString() +
                ", task=" + task.toString() +
                '}';
    }
}
