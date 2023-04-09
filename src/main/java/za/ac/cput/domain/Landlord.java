/* Landlord.java
 POJO class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 7 April 2023
*/
package za.ac.cput.domain;

public class Landlord {

    private String landlordId;

    private String landlordFirstName;

    private String landlordLastName;

    private String landlordEmail;

    private String landlordPassword;

    private String landlordPhone;

    private String landlordAddress;

    private Landlord() {
    }

    public Landlord(Builder builder) {
        this.landlordId = builder.landlordId;
        this.landlordFirstName = builder.landlordFirstName;
        this.landlordLastName = builder.landlordLastName;
        this.landlordEmail = builder.landlordEmail;
        this.landlordPassword = builder.landlordPassword;
        this.landlordPhone = builder.landlordPhone;
        this.landlordAddress = builder.landlordAddress;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public String getLandlordFirstName() {
        return landlordFirstName;
    }

    public String getLandlordLastName() {
        return landlordLastName;
    }

    public String getLandlordEmail() {
        return landlordEmail;
    }

    public String getLandlordPassword() {
        return landlordPassword;
    }

    public String getLandlordPhone() {
        return landlordPhone;
    }

    public String getLandlordAddress() {
        return landlordAddress;
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "landlordId=" + landlordId +
                ", landlordFirstName='" + landlordFirstName + '\'' +
                ", landlordLastName='" + landlordLastName + '\'' +
                ", landlordEmail='" + landlordEmail + '\'' +
                ", landlordPassword='" + landlordPassword + '\'' +
                ", landlordPhone='" + landlordPhone + '\'' +
                ", landlordAddress='" + landlordAddress + '\'' +
                '}';
    }

    public static class Builder {
        private String landlordId;
        private String landlordFirstName;
        private String landlordLastName;
        private String landlordEmail;
        private String landlordPassword;
        private String landlordPhone;
        private String landlordAddress;

        public Builder setLandlordId(String landlordId) {
            this.landlordId = landlordId;
            return this;
        }

        public Builder setLandlordFirstName(String landlordFirstName) {
            this.landlordFirstName = landlordFirstName;
            return this;
        }

        public Builder setLandlordLastName(String landlordLastName) {
            this.landlordLastName = landlordLastName;
            return this;
        }

        public Builder setLandlordEmail(String landlordEmail) {
            this.landlordEmail = landlordEmail;
            return this;
        }

        public Builder setLandlordPassword(String landlordPassword) {
            this.landlordPassword = landlordPassword;
            return this;
        }

        public Builder setLandlordPhone(String landlordPhone) {
            this.landlordPhone = landlordPhone;
            return this;
        }

        public Builder setLandlordAddress(String landlordAddress) {
            this.landlordAddress = landlordAddress;
            return this;
        }

        public Builder copy(Landlord landlord) {
            this.landlordId = landlord.landlordId;
            this.landlordFirstName = landlord.landlordFirstName;
            this.landlordLastName = landlord.landlordLastName;
            this.landlordEmail = landlord.landlordEmail;
            this.landlordPassword = landlord.landlordPassword;
            this.landlordPhone = landlord.landlordPhone;
            this.landlordAddress = landlord.landlordAddress;
            return this;
        }

        public Landlord build() {
            return new Landlord(this);
        }

    }

}
