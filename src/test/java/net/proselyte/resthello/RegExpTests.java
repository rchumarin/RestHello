package net.proselyte.resthello;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.proselyte.resthello.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegExpTests {

    public static Contact FirstTestContact = null;
    public static Contact SecondTestContact = null;

    List<Contact> contacts = null;

    @BeforeClass
    public static void createContact() {
        FirstTestContact = new Contact();
        SecondTestContact = new Contact();

        FirstTestContact.setId(51);
        FirstTestContact.setName("First");

        SecondTestContact.setId(52);
        SecondTestContact.setName("Second");
    }

    @Before
    public void beforeTests() {
        contacts = new ArrayList<Contact>();
        contacts.add(FirstTestContact);
        contacts.add(SecondTestContact);
    }

    @Test
    public void shouldFilterByFirstLetter() throws Exception {
        String exp = "^F.*$";
        Pattern p = Pattern.compile(exp);
        Matcher m = null;

        m = p.matcher(FirstTestContact.getName());
        assertTrue(m.matches());

        m = p.matcher(SecondTestContact.getName());
        assertFalse(m.matches());

    }

    @Test
    public void shouldFilterByNamePart() throws Exception {

        String exp = "^.*[irst].*$";
        Pattern p = Pattern.compile(exp);
        Matcher m = null;

        m = p.matcher(FirstTestContact.getName());
        assertTrue(m.matches());

        m = p.matcher(SecondTestContact.getName());
        assertFalse(m.matches());

    }
}
