package net.proselyte.resthello.repository;


import net.proselyte.resthello.model.Contact;

import java.util.List;

/**
 * Repository class for {@link net.proselyte.resthello.model.Contact's} domain objects.
 *
 * @author Eugene Suleimanov
 */

public interface ContactRepository {

    /**
     * This is method filter contacts in database using defined parameter.
     *
     * @param param
     * @return filteredContacts
     */
    List<Contact> getFilteredContacts(String param);
}
