package net.proselyte.resthello;


import net.proselyte.resthello.config.AppConfig;
import net.proselyte.resthello.model.Contact;
import net.proselyte.resthello.service.ContactService;
import net.proselyte.resthello.service.ContactServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

/**
 * Tests for contact Services
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class ContactServiceTests {
    @Autowired
    private ContactService contactService = new ContactServiceImpl();

    @Test
    public void shouldGetFilteredContacts() throws Exception {
        List<Contact> contactList = this.contactService.getFilteredContacts("");
        Contact contact = contactList.get(0);
        assertThat(contact.getId()).isEqualTo(1);
        assertThat(contact.getName()).isEqualTo("Albert");
    }

    @Test
    public void shouldRetrieveContacts() throws Exception {
        List<Contact> contactList = this.contactService.retrieveContacts(10, 1, "");
        Contact contact = contactList.get(0);
        assertThat(contact.getId()).isEqualTo(1);
        assertThat(contact.getName()).isEqualTo("Albert");
    }
}
