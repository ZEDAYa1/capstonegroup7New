/*
 * Address.java
 * This is the Address class for the Property entity
 * Author: Tshegofatso Molefe {219001235}
 * Date: 6 April 2023
 * */
package za.ac.cput.domain;

public class Address {
    String streetNum;
    String streetName;
    String city;
    String province;

    public Address(){

    }
    public Address(Builder builder) {
        this.streetNum = builder.streetNum;
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.province = builder.province;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNum='" + streetNum + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
    public static class Builder{
        String streetNum;
        String streetName;
        String city;
        String province;

        public Builder setStreetNum(String streetNum) {
            this.streetNum = streetNum;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder copy(Address address) {
            this.streetNum = address.streetNum;
            this.streetName = address.streetName;
            this.city = address.city;
            this.province = address.province;
            return null;
        }

        public Address build(){
            return new Address(this);
        }
    }
}
