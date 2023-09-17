/* Agency.java
 POJO class for Agency
 Author: Zachary Carstens (221054022)
 Date: 17 June 2023
*/
package za.ac.cput.domain;

public class Agency {

    private String agencyId;

    private String name;

    private String contactNumber;

    private String email;

    private String address;

    private Agency(){
    }

    public Agency(Builder builder) {
        this.agencyId = builder.agencyId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "agencyId='" + agencyId + '\'' +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String agencyId;
        private String name;
        private String contactNumber;
        private String email;
        private String address;

        public Builder setAgencyId(String agencyId) {
            this.agencyId = agencyId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
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

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder copy(Agency agency) {
            this.agencyId = agency.agencyId;
            this.name = agency.name;
            this.contactNumber = agency.contactNumber;
            this.email = agency.email;
            this.address = agency.address;
            return this;
        }

        public Agency build() {
            return new Agency(this);
        }

    }

}
