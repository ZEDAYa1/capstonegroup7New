/* ContactRepository.java
 Author: Sibusiso Dwayi(220226466)
 Date: 7 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Contact;

import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactRepository implements IContactRepository{
    private static ContactRepository respository = null;
    private Set<Contact> contactsDB = null;

    private ContactRepository(){
        contactsDB = new HashSet<Contact>();
    }
    public static ContactRepository getRespository(){
        if (respository ==null){
            respository = new ContactRepository();
        }
        return respository;
    }
    @Override
    public Contact create(Contact contact) {
        boolean success = contactsDB.add(contact);
        if (!success)
            return null;
        return contact;
    }

    @Override
    public Contact read(String contactId) {
        for (Contact c : contactsDB) {
            if (c.getContactId().equals(contactId))
                return c;
        }
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        Contact oldContact = read(contact.getContactId());
        if (oldContact != null){
            contactsDB.remove(oldContact);
            contactsDB.add(contact);
            return contact;
        }
        return null;
    }

    @Override
    public boolean delete(String contactId) {
        Contact contactToDelete = read(contactId);
        if (contactToDelete == null)
        return false;
        contactsDB.remove(contactToDelete);
        return true;
    }
    @Override
    public Set<Contact> getAll() {
        return contactsDB;
    }
}
