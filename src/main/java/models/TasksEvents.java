package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tasks_events")
public class TasksEvents {
    @Id
    @ManyToOne
    @JoinColumn(name = "task_id", unique = true)
    private Task task;

    @Id
    @ManyToOne
    @JoinColumn(name = "event_id", unique = true)
    private Event event;

    public TasksEvents() {
    }

    public TasksEvents(Task task, Event event) {
        this.task = task;
        this.event = event;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TasksEvents that = (TasksEvents) o;
        return Objects.equals(task, that.task) && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, event);
    }

    @Override
    public String toString() {
        return "TasksEvents{" +
                "task=" + task +
                ", event=" + event +
                '}';
    }
}
