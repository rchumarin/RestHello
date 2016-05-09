package net.proselyte.resthello.repository;


import net.proselyte.resthello.model.Contact;

import java.util.List;

public interface ContactRepository {
    List<Contact> getFilteredContacts(String param);
}
