package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.util.HashSet;

import domain.member.Member;
import domain.project.Project;
import domain.task.Task;
import domain.team.Team;
import org.junit.Test;

public class ProjectTest {
    @Test
    public void testAddTask() {
        Project project = new Project();
        Task task = new Task();
        project.addTask(task);
        Project project1 = task.getProject();
        assertSame(project, project1);
        assertEquals(1, project1.getTasks().size());
    }

    @Test
    public void testSetTeam() {
        Project project = new Project();
        Team team = new Team();
        project.setTeam(team);
        assertSame(team, project.getTeam());
    }

    @Test
    public void testConstructor() {
        assertEquals("Project{id=0, creator=null, title='null', supervisor=null, members=[], tasks=[]}",
                (new Project()).toString());
    }

    @Test
    public void testSetId() {
        Project project = new Project();
        project.setId(1);
        assertEquals(1, project.getId());
    }

    @Test
    public void testSetCreator() {
        Project project = new Project();
        project.setCreator(new Member());
        assertEquals("Project{id=0, creator=Member{id=0, username='null', firstName='null', lastName='null', email='null',"
                + " password='null'}, title='null', supervisor=null, members=[], tasks=[]}", project.toString());
    }

    @Test
    public void testSetTitle() {
        Project project = new Project();
        project.setTitle("Dr");
        assertEquals("Dr", project.getTitle());
    }

    @Test
    public void testSetSupervisor() {
        Project project = new Project();
        project.setSupervisor(new Member());
        assertEquals("Project{id=0, creator=null, title='null', supervisor=Member{id=0, username='null', firstName='null',"
                + " lastName='null', email='null', password='null'}, members=[], tasks=[]}", project.toString());
    }

    @Test
    public void testSetMembers() {
        Project project = new Project();
        project.setMembers(new HashSet<Member>());
        assertEquals("Project{id=0, creator=null, title='null', supervisor=null, members=[], tasks=[]}",
                project.toString());
    }

    @Test
    public void testSetTasks() {
        Project project = new Project();
        project.setTasks(new HashSet<Task>());
        assertEquals("Project{id=0, creator=null, title='null', supervisor=null, members=[], tasks=[]}",
                project.toString());
    }

    @Test
    public void testToString() {
        assertEquals("Project{id=0, creator=null, title='null', supervisor=null, members=[], tasks=[]}",
                (new Project()).toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new Project()).equals("o"));
        assertFalse((new Project()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(887503681, (new Project()).hashCode());
    }
}

