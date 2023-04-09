/* Contact.java
 Entity for the Contact
 Author: Sibusiso Dwayi(220226466)
 Date: 31 March 2023
*/
package za.ac.cput.domain;

public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private Contact() {

    }

    private Contact(ContactBuilder builder) {
        this.contactId = builder.contactId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }

    public static class ContactBuilder {
        private String contactId;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;

        public ContactBuilder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public ContactBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ContactBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ContactBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public ContactBuilder copy(Contact contact) {
            this.contactId = contact.contactId;
            this.firstName = contact.firstName;
            this.lastName = contact.lastName;
            this.email = contact.email;
            this.phone = contact.phone;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}

