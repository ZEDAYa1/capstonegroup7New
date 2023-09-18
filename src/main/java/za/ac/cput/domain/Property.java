package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Property implements Serializable {
    @Id
    @Column(name = "property_id")
    private String propertyId;

    @NotNull
    private String address;

    private double rentAmount;

    private String description;

    protected Property() {}

    private Property(Builder builder) {
        this.propertyId = builder.propertyId;
        this.address = builder.address;
        this.rentAmount = builder.rentAmount;
        this.description = builder.description;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getAddress() {
        return address;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.rentAmount, rentAmount) == 0 &&
                Objects.equals(propertyId, property.propertyId) &&
                Objects.equals(address, property.address) &&
                Objects.equals(description, property.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, address, rentAmount, description);
    }

    public static class Builder {
        private String propertyId;
        private String address;
        private double rentAmount;
        private String description;

        public Builder setPropertyId(String propertyId) {
            this.propertyId = propertyId;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setRentAmount(double rentAmount) {
            this.rentAmount = rentAmount;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Property property) {
            this.propertyId = property.propertyId;
            this.address = property.address;
            this.rentAmount = property.rentAmount;
            this.description = property.description;
            return this;
        }

        public Property build() {
            return new Property(this);
        }
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId='" + propertyId + '\'' +
                ", address='" + address + '\'' +
                ", rentAmount=" + rentAmount +
                ", description='" + description + '\'' +
                '}';
    }
}
