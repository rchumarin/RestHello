package net.proselyte.resthello.service;


import net.proselyte.resthello.model.Contact;

import java.util.List;

/**
 * Services of {@link net.proselyte.resthello.model.Contact} domain object.
 *
 * @author Eugene Suleimanov
 */

public interface ContactService {
    List<Contact> getFilteredContacts(String param);

    public List<Contact> retrieveContacts(int pageSize, int pageNumber, String param);
}
