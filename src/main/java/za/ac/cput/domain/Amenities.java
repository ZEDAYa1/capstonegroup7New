package za.ac.cput.domain;

//sonwabiso Moni
//219275041


public class Amenities {
    private String nrOfSwimmingPools;
    private String availableParking;
    private String wellnessFacilities;
    private String location;
    private String packageRooms;
    private String laundryFacilities;
    private String PropertyID;

    private Amenities(){}
    private Amenities(Builder builder){
        this.availableParking=builder.availableParking;
        this.laundryFacilities= builder.laundryFacilities;
        this.location= builder.location;
        this.wellnessFacilities= builder.wellnessFacilities;
        this.nrOfSwimmingPools= builder.nrOfSwimmingPools;;
        this.packageRooms= builder.packageRooms;
        this.PropertyID= builder.PropertyID;


    }

    public String getNrOfSwimmingPools() {
        return nrOfSwimmingPools;
    }

    public String getPropertyID() {
        return PropertyID;
    }

    public String getAvailableParking() {
        return availableParking;
    }

    public String getWellnessFacilities() {
        return wellnessFacilities;
    }

    public String getLocation() {
        return location;
    }

    public String getPackageRooms() {
        return packageRooms;
    }

    public String getLaundryFacilities() {
        return laundryFacilities;
    }

    @Override
    public String toString() {
        return "Amenities{" +
                "nrOfSwimmingPools='" + nrOfSwimmingPools + '\'' +
                ", availableParking='" + availableParking + '\'' +
                ", wellnessFacilities='" + wellnessFacilities + '\'' +
                ", location='" + location + '\'' +
                ", packageRooms='" + packageRooms + '\'' +
                ", laundryFacilities='" + laundryFacilities + '\'' +
                ", PropertyID='" + PropertyID + '\'' +
                '}';
    }

    public static class Builder{
        private String nrOfSwimmingPools;
        private String availableParking;
        private String wellnessFacilities;
        private String location;
        private String packageRooms;
        private String laundryFacilities;
        private String PropertyID;


        public Builder setNrOfSwimmingPools(String nrOfSwimmingPools) {
            this.nrOfSwimmingPools = nrOfSwimmingPools;
            return this;
        }

        public  Builder setAvailableParking(String availableParking) {
            this.availableParking = availableParking;
            return this;
        }

        public Builder setWellnessFacilities(String wellnessFacilities) {
            this.wellnessFacilities = wellnessFacilities;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setPackageRooms(String packageRooms) {
            this.packageRooms = packageRooms;
            return this;
        }

        public Builder setLaundryFacilities(String laundryFacilities) {
            this.laundryFacilities = laundryFacilities;
            return this;
        }

        public Builder setPropertyID(String propertyID) {
            PropertyID = propertyID;
            return this;
        }

        public Builder copy(Amenities amenities){
            this.availableParking= amenities.availableParking;
            this.laundryFacilities=amenities.laundryFacilities;
            this.location= amenities.location;
            this.wellnessFacilities= amenities.wellnessFacilities;
            this.packageRooms= amenities.packageRooms;
            this.nrOfSwimmingPools= amenities.nrOfSwimmingPools;
            this.PropertyID=amenities.PropertyID;
            return this;

        }
        public Amenities build(){return new Amenities(this);}

    }
}

