package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import domain.member.Member;
import domain.team.Team;
import org.junit.Test;

public class MemberTest {
    @Test
    public void testSetTeam() {
        Member member = new Member();
        Team team = new Team();
        member.setTeam(team);
        assertSame(team, member.getTeam());
    }

    @Test
    public void testSetId() {
        Member member = new Member();
        member.setId(1);
        assertEquals(1, member.getId());
    }

    @Test
    public void testSetUsername() {
        Member member = new Member();
        member.setUsername("janedoe");
        assertEquals("janedoe", member.getUsername());
    }

    @Test
    public void testSetFirstName() {
        Member member = new Member();
        member.setFirstName("Jane");
        assertEquals("Jane", member.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Member member = new Member();
        member.setLastName("Doe");
        assertEquals("Doe", member.getLastName());
    }

    @Test
    public void testSetEmail() {
        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        assertEquals("jane.doe@example.org", member.getEmail());
    }

    @Test
    public void testSetPassword() {
        Member member = new Member();
        member.setPassword("iloveyou");
        assertEquals("iloveyou", member.getPassword());
    }

    @Test
    public void testEquals() {
        assertFalse((new Member()).equals("o"));
        assertFalse((new Member()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(887503681, (new Member()).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Member{id=0, username='null', firstName='null', lastName='null', email='null', password='null'}",
                (new Member()).toString());
    }

    @Test
    public void testSetRole() {
        Member member = new Member();
        member.setRole(Member.Role.SUPERUSER);
        assertEquals(Member.Role.SUPERUSER, member.getRole());
    }
}

