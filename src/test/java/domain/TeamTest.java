package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.util.HashSet;

import org.junit.Test;

public class TeamTest {
    @Test
    public void testConstructor() {
        assertEquals("Team{id=0, title='null', members=[], projects=[]}", (new Team()).toString());
    }

    @Test
    public void testAddMember() {
        Team team = new Team();
        Member member = new Member();
        team.addMember(member);
        Team team1 = member.getTeam();
        assertSame(team, team1);
        assertEquals(1, team1.getMembers().size());
    }

    @Test
    public void testAddMember2() {
        HashSet<Member> memberSet = new HashSet<Member>();
        memberSet.add(null);
        Team team = new Team();
        team.setMembers(memberSet);
        Member member = new Member();
        team.addMember(member);
        Team team1 = member.getTeam();
        assertSame(team, team1);
        assertEquals(2, team1.getMembers().size());
    }

    @Test
    public void testSetId() {
        Team team = new Team();
        team.setId(1);
        assertEquals(1, team.getId());
    }

    @Test
    public void testSetTitle() {
        Team team = new Team();
        team.setTitle("Dr");
        assertEquals("Dr", team.getTitle());
    }

    @Test
    public void testSetMembers() {
        Team team = new Team();
        team.setMembers(new HashSet<Member>());
        assertEquals("Team{id=0, title='null', members=[], projects=[]}", team.toString());
    }

    @Test
    public void testSetProjects() {
        Team team = new Team();
        team.setProjects(new HashSet<Project>());
        assertEquals("Team{id=0, title='null', members=[], projects=[]}", team.toString());
    }

    @Test
    public void testToString() {
        assertEquals("Team{id=0, title='null', members=[], projects=[]}", (new Team()).toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new Team()).equals("o"));
        assertFalse((new Team()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(923521, (new Team()).hashCode());
    }
}

