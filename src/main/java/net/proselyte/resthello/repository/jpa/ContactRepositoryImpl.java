package net.proselyte.resthello.repository.jpa;

import net.proselyte.resthello.model.Contact;
import net.proselyte.resthello.repository.ContactRepository;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JPA implementation of {@link net.proselyte.resthello.repository.ContactRepository} interface.
 *
 * @author Eugene Suleimanov
 */

@Repository
public class ContactRepositoryImpl implements ContactRepository {

    private static final Logger logger = LoggerFactory.getLogger(ContactRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> getFilteredContacts(String param) {
        Pattern pattern = Pattern.compile(param);
        List<Contact> contacts = new LinkedList<>();

        StatelessSession session = this.sessionFactory.openStatelessSession();

        ScrollableResults contactCursor = session.createQuery("from Contact").scroll(ScrollMode.FORWARD_ONLY);

        logger.info("Getting contacts that meet pattern: " + param + "...");
        long start = System.currentTimeMillis();
        while (contactCursor.next()) {
            Contact currentContact = (Contact) contactCursor.get(0);
            Matcher m = pattern.matcher(currentContact.getName());
            if (!m.matches()) {
                contacts.add(currentContact);
            }
        }
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;

        logger.info(timeElapsed + " ms elapsed for retrieving and processing data.");

        contactCursor.close();
        session.close();

        logger.info(contacts.size() + " contacts found.");

        return contacts;
    }


    /**
     * Methods for paging
     */
    public List<Contact> retrieveContactsWithPaging(int pageSize, int pageNumber, String param) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Contact> contacts = null;

        Query query = session.createQuery("from Contact");
        query = query.setFirstResult(pageSize * (pageNumber - 1));
        query.setMaxResults(pageSize);
        contacts = query.list();

        return filterContacts(contacts, param);
    }

    private LinkedList<Contact> filterContacts(List<Contact> allContacts, String param) {

        Pattern p = Pattern.compile(param);
        LinkedList<Contact> sortedContacts = new LinkedList<Contact>(allContacts);

        Iterator<Contact> itr = sortedContacts.iterator();
        while (itr.hasNext()) {
            Contact currentContact = itr.next();
            Matcher m = p.matcher(currentContact.getName());
            if (m.matches()) itr.remove();
        }

        return sortedContacts;
    }
}
