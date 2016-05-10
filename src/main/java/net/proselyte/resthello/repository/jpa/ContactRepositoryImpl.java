package net.proselyte.resthello.repository.jpa;

import net.proselyte.resthello.model.Contact;
import net.proselyte.resthello.repository.ContactRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
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
        String hql = "from Contact";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        List<Contact> contacts = query.list();
        for (Contact contact : contacts) {
            logger.info("Filtered contacts lis: " + contact);
        }


        return filterContacts(contacts, param);
    }


    /**
     * This method filter contacts that meet required pattern
     */
    private LinkedList<Contact> filterContacts(List<Contact> contacts, String param) {

        Pattern p = Pattern.compile(param);
        LinkedList<Contact> filteredContacts = new LinkedList<Contact>(contacts);

        logger.info("Filtering contacts...");

        Iterator<Contact> itr = filteredContacts.iterator();
        while (itr.hasNext()) {
            Contact currentContact = itr.next();
            Matcher m = p.matcher(currentContact.getName());
            if (m.matches()) {
                logger.info("Contact removed from list: " + itr);
                itr.remove();
            }
        }
        return filteredContacts;
    }
}
