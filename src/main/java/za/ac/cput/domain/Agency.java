/* Agency.java
 POJO class for Agency
 Author: Zachary Carstens (221054022)
 Date: 17 June 2023
*/
package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Agency implements Serializable {
    @Id
    @Column(name = "agency_id")
    private String agencyId;

    @NotNull
    private String name;

    private String contactNumber;

    private String email;

    private String address;

    protected Agency() {}

    private Agency(Builder builder) {
        this.agencyId = builder.agencyId;
        this.name = builder.name;
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
        this.address = builder.address;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return Objects.equals(agencyId, agency.agencyId) &&
                Objects.equals(name, agency.name) &&
                Objects.equals(contactNumber, agency.contactNumber) &&
                Objects.equals(email, agency.email) &&
                Objects.equals(address, agency.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencyId, name, contactNumber, email, address);
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
}
