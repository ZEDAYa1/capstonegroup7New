package za.ac.cput.domain;

//sonwabiso Moni
//219275041


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Features implements Serializable {


    @Id
    private String propertyID;

    private boolean kitchen ;
    private boolean garage;

    private double size;

    private int bathrooms;

    private  int bedrooms;

    private String pool;

    private boolean lounge;
    private boolean laundry;

    protected Features(){}
    private Features(Builder builder){
        this.garage=builder.garage;
        this.laundry= builder.laundry;
        this.pool= builder.pool;
        this.size= builder.size;
        this.bedrooms= builder.bedrooms;
        this.bathrooms= builder.bathrooms;
        this.propertyID= builder.propertyID;
        this.lounge= builder.lounge;
        this.kitchen= builder.kitchen;



    }

    public boolean isKitchen() {
        return kitchen;
    }

    public boolean isGarage() {
        return garage;
    }

    public double getSize() {
        return size;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public String getPool() {
        return pool;
    }

    public boolean isLounge() {
        return lounge;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public String getPropertyID() {
        return propertyID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Features features = (Features) o;
        return kitchen == features.kitchen && garage == features.garage && Double.compare(size, features.size) == 0 && bathrooms == features.bathrooms && bedrooms == features.bedrooms && lounge == features.lounge && laundry == features.laundry && Objects.equals(pool, features.pool) && Objects.equals(propertyID, features.propertyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kitchen, garage, size, bathrooms, bedrooms, pool, lounge, laundry, propertyID);
    }

    @Override
    public String toString() {
        return "Features{" +
                "kitchen=" + kitchen +
                ", garage=" + garage +
                ", size=" + size +
                ", bathrooms=" + bathrooms +
                ", bedrooms=" + bedrooms +
                ", pool='" + pool + '\'' +
                ", lounge=" + lounge +
                ", laundry=" + laundry +
                ", propertyID='" + propertyID + '\'' +
                '}';
    }




    public static class Builder{
        private boolean kitchen ;
        private boolean garage;

        private double size;

        private int bathrooms;

        private  int bedrooms;

        private String pool;

        private boolean lounge;
        private boolean laundry;
        private String propertyID;


        public Builder setKitchen(boolean kitchen) {
            this.kitchen = kitchen;
            return this;
        }

        public Builder setGarage(boolean garage) {
            this.garage = garage;
            return this;
        }

        public Builder setSize(double size) {
            this.size = size;
            return this;
        }

        public Builder setBathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public Builder setBedrooms(int bedrooms) {
            this.bedrooms = bedrooms;
            return this;
        }

        public Builder setPool(String pool) {
            this.pool = pool;
            return this;
        }

        public Builder setLounge(boolean lounge) {
            this.lounge = lounge;
            return this;
        }

        public Builder setLaundry(boolean laundry) {
            this.laundry=laundry;
            return this;
        }

        public Builder setPropertyID(String propertyID) {
            this.propertyID = propertyID;
            return this;
        }

        public Builder copy(Features features){
           this.laundry=features.laundry;
           this.pool=features.pool;
           this.size= features.size;
           this.kitchen= features.kitchen;
           this.lounge= features.lounge;
           this.bathrooms= features.bathrooms;
           this.bedrooms= features.bedrooms;
           this.garage= features.garage;
           this.propertyID= features.propertyID;
            return this;

        }
        public Features build(){return new Features(this);}

    }
}

