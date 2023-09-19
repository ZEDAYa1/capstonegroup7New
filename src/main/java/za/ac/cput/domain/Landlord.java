/* Landlord.java
 POJO class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 7 April 2023
*/
package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Landlord implements Serializable {
    @Id
    @Column(name = "landlord_id")
    private String landlordId;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    private String contactNumber;

    private String email;

    private String password;

    private String address;

    protected Landlord() {
    }

    private Landlord(Builder builder) {
        this.landlordId = builder.landlordId;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
        this.password = builder.password;
        this.address = builder.address;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Landlord landlord = (Landlord) o;
        return Objects.equals(landlordId, landlord.landlordId) && Objects.equals(firstname, landlord.firstname)
                && Objects.equals(lastname, landlord.lastname) && Objects.equals(contactNumber, landlord.contactNumber)
                && Objects.equals(email, landlord.email) && Objects.equals(password, landlord.password)
                && Objects.equals(address, landlord.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(landlordId, firstname, lastname, contactNumber, email, password, address);
    }

    public static class Builder {
        private String landlordId;
        private String firstname;
        private String lastname;
        private String contactNumber;
        private String email;
        private String password;
        private String address;

        public Builder setLandlordId(String landlordId) {
            this.landlordId = landlordId;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder copy(Landlord landlord) {
            this.landlordId = landlord.landlordId;
            this.firstname = landlord.firstname;
            this.lastname = landlord.lastname;
            this.contactNumber = landlord.contactNumber;
            this.email = landlord.email;
            this.password = landlord.password;
            this.address = landlord.address;
            return this;
        }

        public Landlord build() {
            return new Landlord(this);
        }
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "landlordId='" + landlordId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
