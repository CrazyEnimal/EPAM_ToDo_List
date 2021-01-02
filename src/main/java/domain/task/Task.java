package domain.task;

import domain.Member;
import domain.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * @author Georgiy Minasian
 */
public class Task {
    public static Logger logger = LogManager.getLogger();

    private String title;
    private int id;
    private boolean isComplete = false;
    private Member creator;
    private Member executor;
    private Status status = new Status(-1, "Basic status", new Project()); //NPE protection - default notNull object

    //todo: Event event, Member followers, Message messages fields
    private String description = "";
    private Priority priority = Priority.NORMAL;

    public Task() {
        logger.info("task created by default constructor");
    }

    public Task(String title, int id, String description, Priority priority) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.priority = priority;
        logger.info("task created by parametrized constructor with: \n"
                + "title: " + title + "\n"
                + "id: " + id + "\n"
                + "description: " + description + "\n"
                + "priority: " + priority + "\n"
                + "status: " + status.getTitle()
                );
    }

    public static Task addTask(String jsonString) {
        JSONSpacer js = new JSONSpacer();
        Task task = js.getTaskFromJSONString(jsonString);
        logger.info("Input task created from JSON string");
        return task;
    }

    //todo: task delete methods

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Member getCreator() {
        return creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public Member getExecutor() {
        return executor;
    }

    public void setExecutor(Member executor) {
        this.executor = executor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //todo: followers, event and messages setters and getters

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                isComplete == task.isComplete &&
                title.equals(task.title) &&
                creator.equals(task.creator) &&
                executor.equals(task.executor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, isComplete, creator, executor);
    }

    @Override
    public String toString() {
        return "title: " + title + ", " + "\n" +
                "id: " + id + ", " + "\n" +
                "isComplete: " + isComplete + ", " + "\n" +
                "creator: " + creator + ", " + "\n" +
                "executor: " + executor + ", " + "\n" +
                "status id: " + status.getId() + "\n";
    }
}
