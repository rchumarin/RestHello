package net.proselyte.resthello.service;

import net.proselyte.resthello.model.Contact;
import net.proselyte.resthello.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link net.proselyte.resthello.service.ContactService} interface.
 *
 * @author Eugene Suleimanov
 */

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    @Transactional
    public List<Contact> getFilteredContacts(String param) {
        return contactRepository.getFilteredContacts(param);
    }

    @Override
    @Transactional
    public List<Contact> retrieveContacts(int pageSize, int pageNumber, String param) {
        return contactRepository.retrieveContactsWithPaging(pageSize, pageNumber, param);
    }

}
