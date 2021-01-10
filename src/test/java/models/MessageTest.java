package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.util.Date;

import org.junit.Test;

public class MessageTest {
    @Test
    public void testSetCreator() {
        Message message = new Message();
        Member member = new Member();
        message.setCreator(member);
        assertSame(member, message.getCreator());
    }

    @Test
    public void testSetDate() {
        Date date = new Date(1L);
        Message message = new Message();
        message.setDate(date);
        assertSame(date, message.getDate());
    }

    @Test
    public void testSetText() {
        Message message = new Message();
        message.setText("Text");
        assertEquals("Text", message.getText());
    }

    @Test
    public void testSetType() {
        Message message = new Message();
        message.setType("Type");
        assertEquals("Type", message.getType());
    }

    @Test
    public void testEquals() {
        assertFalse((new Message()).equals("o"));
        assertFalse((new Message()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(31, (new Message()).hashCode());
    }

    @Test
    public void testToString() {
        Member creator = new Member("janedoe", "Jane", "Doe", "jane.doe@example.org", "iloveyou", new Role());
        Message message = new Message();
        message.setCreator(creator);
        assertEquals("Message{id=0, creator=Member{id=0, userName='janedoe', firstName='Jane', lastName='Doe', email='jane"
                + ".doe@example.org', password='iloveyou', role='Role{id=0, title='null'}'}, date=null, text='null',"
                + " type='null'}", message.toString());
    }
}

