/* Landlord.java
 POJO class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 7 April 2023
*/
package za.ac.cput.domain;

public class Landlord {

    private String landlordId;

    private String firstName;

    private String lastName;

    private String contactNumber;

    private String email;

    private String password;

    private String address;

    private Landlord() {
    }

    public Landlord(Builder builder) {
        this.landlordId = builder.landlordId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
        this.password = builder.password;
        this.address = builder.address;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public String getLandlordFirstName() {
        return firstName;
    }

    public String getLandlordLastName() {
        return lastName;
    }

    public String getLandlordPhone() {
        return contactNumber;
    }

    public String getLandlordEmail() {
        return email;
    }

    public String getLandlordPassword() {
        return password;
    }

    public String getLandlordAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "landlordId=" + landlordId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String landlordId;
        private String firstName;
        private String lastName;
        private String contactNumber;
        private String email;
        private String password;
        private String address;

        public Builder setLandlordId(String landlordId) {
            this.landlordId = landlordId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
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

        public Builder setAddress(String landlordAddress) {
            this.address = address;
            return this;
        }

        public Builder copy(Landlord landlord) {
            this.landlordId = landlord.landlordId;
            this.firstName = landlord.firstName;
            this.lastName = landlord.lastName;
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

}
