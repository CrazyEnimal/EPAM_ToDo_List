package domain;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class TaskTest {
    @Test
    public void testSetProject() {
        Task task = new Task();
        Project project = new Project();
        task.setProject(project);
        assertSame(project, task.getProject());
    }
}

