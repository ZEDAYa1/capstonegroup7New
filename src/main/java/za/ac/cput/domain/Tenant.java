package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Tenant implements Serializable {
    @Id
    @Column(name = "tenant_id")
    private String tenantId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String contactNumber;

    private String email;

    private String leaseId;

    protected Tenant() {}

    private Tenant(Builder builder) {
        this.tenantId = builder.tenantId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
        this.leaseId = builder.leaseId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLeaseId() {
        return leaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(tenantId, tenant.tenantId) &&
                Objects.equals(firstName, tenant.firstName) &&
                Objects.equals(lastName, tenant.lastName) &&
                Objects.equals(contactNumber, tenant.contactNumber) &&
                Objects.equals(email, tenant.email) &&
                Objects.equals(leaseId, tenant.leaseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId, firstName, lastName, contactNumber, email, leaseId);
    }

    public static class Builder {
        private String tenantId;
        private String firstName;
        private String lastName;
        private String contactNumber;
        private String email;
        private String leaseId;

        public Builder setTenantId(String tenantId) {
            this.tenantId = tenantId;
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

        public Builder setLeaseId(String leaseId) {
            this.leaseId = leaseId;
            return this;
        }

        public Builder copy(Tenant tenant) {
            this.tenantId = tenant.tenantId;
            this.firstName = tenant.firstName;
            this.lastName = tenant.lastName;
            this.contactNumber = tenant.contactNumber;
            this.email = tenant.email;
            this.leaseId = tenant.leaseId;
            return this;
        }

        public Tenant build() {
            return new Tenant(this);
        }
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "tenantId='" + tenantId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", leaseId='" + leaseId + '\'' +
                '}';
    }
}
