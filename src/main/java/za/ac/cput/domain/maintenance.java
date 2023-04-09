package za.ac.cput.domain;

//sonwabiso Moni
//219275041

import java.util.Objects;



public class maintenance {

    private String maintenanceID;
    private String Location;
    private String HouseNr;
    private String Address;
    private String TenantName;


    private maintenance(){}
    private maintenance(Builder builder){
        this.Address= builder.Address;
        this.HouseNr= builder.HouseNr;
        this.Location= builder.Location;
        this.TenantName= builder.TenantName;
        this.maintenanceID=builder.maintenanceID;




    }


    public String getLocation() {
        return Location;
    }

    public String getHouseNr() {
        return HouseNr;
    }

    public String getAddress() {
        return Address;
    }

    public String getTenantName() {
        return TenantName;
    }






    public String getMaintenanceID() {
        return maintenanceID;
    }

    @Override
    public String toString() {
        return "maintenance{" +
                "maintenanceID='" + maintenanceID + '\'' +
                ", Location='" + Location + '\'' +
                ", HouseNr='" + HouseNr + '\'' +
                ", Address='" + Address + '\'' +
                ", TenantName='" + TenantName + '\'' +
                '}';
    }

    public static class Builder{
        private String Location;
        private String HouseNr;
        private String Address;
        private String TenantName;
        private String maintenanceID;

        public Builder setMaintenanceID(String maintenanceID) {
            this.maintenanceID = maintenanceID;
            return this;
        }

        public Builder setLocation(String location) {
            Location = location;
            return this;
        }

        public Builder setHouseNr(String houseNr) {
            HouseNr = houseNr;
            return this;
        }

        public Builder setAddress(String address) {
            Address = address;
            return this;
        }

        public Builder setTenantName(String tenantName) {
            TenantName = tenantName;
            return this;
        }

        public Builder copy (maintenance maintenance){
            this.Address=maintenance.Address;
            this.TenantName=maintenance.TenantName;
            this.HouseNr=maintenance.HouseNr;
            this.Location=maintenance.Location;
            this.maintenanceID=maintenance.maintenanceID;

            return this;

        }
        public maintenance build(){ return new maintenance(this);}








    }







}

