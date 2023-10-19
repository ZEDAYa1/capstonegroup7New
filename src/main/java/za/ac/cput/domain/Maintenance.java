package za.ac.cput.domain;

//sonwabiso Moni
//219275041


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Maintenance implements Serializable {


    @Id
    @Column(name = "request_id")
    private String requestId;
    private String propertyId;
    public String description;
    public LocalDate requestDate;


    protected Maintenance(){}
    private Maintenance(Builder builder){
        this.requestId= builder.requestId;
        this.description= builder.description;
        this.requestDate=builder.requestDate;
        this.propertyId= builder.propertyId;



    }


    public String getRequestId() {
        return requestId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maintenance that = (Maintenance) o;
        return Objects.equals(requestId, that.requestId) && Objects.equals(propertyId, that.propertyId) && Objects.equals(description, that.description) && Objects.equals(requestDate, that.requestDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, propertyId, description, requestDate);
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "requestId='" + requestId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", description='" + description + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }

    public static class Builder{
        private String requestId;
        private String propertyId;
        public String description;
        public LocalDate requestDate;

        public Builder setRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder setPropertyId(String propertyId) {
            this.propertyId = propertyId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setRequestDate(LocalDate requestDate) {
            this.requestDate = requestDate;
            return this;
        }

        public Builder copy (Maintenance maintenance){
           this.requestId= maintenance.requestId;
           this.requestDate=maintenance.requestDate;
           this.propertyId= maintenance.propertyId;
           this.description= maintenance.description;

            return this;

        }
        public Maintenance build(){ return new Maintenance(this);}

    }
}

