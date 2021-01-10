package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class ProjectTest {
    @Test
    public void testSetCreator() {
        Project project = new Project();
        Member member = new Member();
        project.setCreator(member);
        assertSame(member, project.getCreator());
    }

    @Test
    public void testSetSupervisor() {
        Project project = new Project();
        Member member = new Member();
        project.setSupervisor(member);
        assertSame(member, project.getSupervisor());
    }

    @Test
    public void testSetTitle() {
        Project project = new Project();
        project.setTitle("Dr");
        assertEquals("Dr", project.getTitle());
    }

    @Test
    public void testEquals() {
        assertFalse((new Project()).equals("o"));
        assertFalse((new Project()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(31, (new Project()).hashCode());
    }

    @Test
    public void testToString() {
        Member supervisor = new Member("janedoe", "Jane", "Doe", "jane.doe@example.org", "iloveyou", new Role());
        Project project = new Project();
        project.setSupervisor(supervisor);
        project.setCreator(new Member("janedoe", "Jane", "Doe", "jane.doe@example.org", "iloveyou", new Role()));
        assertEquals("Project{id=0, creator=Member{id=0, userName='janedoe', firstName='Jane', lastName='Doe', email='jane"
                + ".doe@example.org', password='iloveyou', role='Role{id=0, title='null'}'}, supervisor=Member{id=0,"
                + " userName='janedoe', firstName='Jane', lastName='Doe', email='jane.doe@example.org', password='iloveyou',"
                + " role='Role{id=0, title='null'}'}, title='null'}", project.toString());
    }
}

