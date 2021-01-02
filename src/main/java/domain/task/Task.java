package domain.task;

import domain.Member;
import java.util.Objects;

/**
 * @author Georgiy Minasian
 */
public class Task {
    private String title;
    private int id;
    private boolean isComplete = false;
    private Member creator;
    private Member executor;
    private Status status = new Status(-1); //NPE protection - default notNull object


    //todo: Event event, Member followers, Message messages fields
    private String description = "";
    private Priority priority = Priority.NORMAL;

    public Task() {
    }

    public Task(String title, int id, String description, Priority priority) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public Task addTask(String jsonString) {
        JSONSpacer js = new JSONSpacer();
        Task inputTask = js.getTaskFromJSONString(jsonString);
        Task outputTask = new Task();

        outputTask.setCreator(inputTask.getCreator());
        outputTask.setExecutor(inputTask.getExecutor());
        outputTask.setTitle(inputTask.getTitle());
        outputTask.setId(inputTask.getId());
        outputTask.setComplete(inputTask.isComplete());

        if (inputTask.getDescription().length() > 0) {
            outputTask.setDescription(inputTask.getDescription());
        }

        if (inputTask.getStatusId() > 0) {
            outputTask.setStatusId(inputTask.getStatusId());
        }

        //todo: event, followers and messages checking and setting

        if (inputTask.getPriority() != Priority.NORMAL) {
            outputTask.setPriority(inputTask.getPriority());
        }



        return outputTask;
    }

    //todo: task edit and task delete methods

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public boolean isComplete() {
        return isComplete;
    }

    private void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Member getCreator() {
        return creator;
    }

    private void setCreator(Member creator) {
        this.creator = creator;
    }

    public Member getExecutor() {
        return executor;
    }

    private void setExecutor(Member executor) {
        this.executor = executor;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public int getStatusId() {
        return status.getId();
    }

    private void setStatusId(int statusId) {
        status.setId(statusId);
    }

    //todo: followers, event and messages setters and getters

    public Priority getPriority() {
        return priority;
    }

    private void setPriority(Priority priority) {
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
                "executor: " + executor + "\n" +
                "status id: " + status.getId() + "\n";
    }
}
