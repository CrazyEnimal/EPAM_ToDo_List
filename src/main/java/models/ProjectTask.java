package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projects_tasks")
public class ProjectTask {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", unique = true)
    private Task task;

    public ProjectTask() {

    }

    public ProjectTask(Project project, Task task) {
        this.project = project;
        this.task = task;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return Objects.equals(project, that.project) && Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, task);
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                ", project=" + project.toString() +
                ", task=" + task.toString() +
                '}';
    }
}
