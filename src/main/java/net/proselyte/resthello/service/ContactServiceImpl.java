package net.proselyte.resthello.service;

import net.proselyte.resthello.model.Contact;
import net.proselyte.resthello.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Transactional
    @Override
    public List<Contact> getFilteredContacts(String param) {
        return contactRepository.getFilteredContacts(param);
    }

}
