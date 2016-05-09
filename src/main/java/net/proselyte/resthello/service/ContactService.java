package net.proselyte.resthello.service;



import net.proselyte.resthello.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getFilteredContacts(String param);
}
