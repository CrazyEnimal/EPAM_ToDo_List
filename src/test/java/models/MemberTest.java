package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class MemberTest {
    @Test
    public void testEquals() {
        assertFalse((new Member()).equals("o"));
        assertFalse((new Member()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(31, (new Member()).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(
                "Member{id=0, userName='janedoe', firstName='Jane', lastName='Doe', email='jane.doe@example.org',"
                        + " password='iloveyou', role='Role{id=0, title='null'}'}",
                (new Member("janedoe", "Jane", "Doe", "jane.doe@example.org", "iloveyou", new Role())).toString());
    }
}

