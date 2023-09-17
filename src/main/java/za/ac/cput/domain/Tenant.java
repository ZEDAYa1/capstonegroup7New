/*
 * Tenant.java
 * This is the tenant entity
 * Author: Tshegofatso Molefe {219001235}
 * Date: 6 April 2023
 * */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Tenant {

   @Id
   //@GeneratedValue(strategy = GenerationType.AUTO)
    private String tenantID;
    private String leaseID;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;

//    private Tenant(){
//    }

    public Tenant(Builder builder) {
        this.tenantID = builder.tenantID;
        this.leaseID = builder.leaseID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.contactNumber = builder.contactNumber;
    }

    public Tenant() {

    }

    public String getTenantID() {
        return tenantID;
    }
    public String getLeaseID() {
        return leaseID;
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
    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(tenantID, tenant.tenantID) && Objects.equals(leaseID, tenant.leaseID) &&
                Objects.equals(firstName, tenant.firstName) && Objects.equals(lastName, tenant.lastName) &&
                Objects.equals(email, tenant.email) && Objects.equals(contactNumber, tenant.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantID, leaseID, firstName, lastName, email, contactNumber);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "tenantID='" + tenantID + '\'' +
                ", leaseID='" + leaseID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

//Builder Pattern

    public static class Builder{
        private String tenantID, leaseID, firstName, lastName, email, contactNumber;

        public Builder setTenantID(String tenantID) {
            this.tenantID = tenantID;
            return this;
        }

        public Builder setLeaseID(String leaseID) {
            this.leaseID = leaseID;
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

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder copy(Tenant tenant){
            this.tenantID = tenant.tenantID;
            this.firstName = tenant.firstName;
            this.lastName = tenant.lastName;
            this.email = tenant.email;
            this.contactNumber = tenant.contactNumber;
            return this;
        }

        public Tenant build(){
            return new Tenant(this);
        }
    }
}
