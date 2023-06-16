///*
// * PropertyType.java
// * This is the PropertyType class for the Property entity
// * Author: Tshegofatso Molefe {219001235}
// * Date: 6 April 2023
// * */
//package za.ac.cput.domain;
//
//public class PropertyType {
//    String apartment;
//    String house;
//    String townhouse;
//
//    public PropertyType(){
//    }
//    public PropertyType(Builder builder) {
//        this.apartment = builder.apartment;
//        this.house = builder.house;
//        this.townhouse = builder.townhouse;
//    }
//
//    public String getApartment() {
//        return apartment;
//    }
//
//    public PropertyType setApartment(String apartment) {
//        this.apartment = apartment;
//        return null;
//    }
//
//    public String getHouse() {
//        return house;
//    }
//
//    public void setHouse(String house) {
//        this.house = house;
//    }
//
//    public String getTownhouse() {
//        return townhouse;
//    }
//
//    public void setTownhouse(String townhouse) {
//        this.townhouse = townhouse;
//    }
//
//    @Override
//    public String toString() {
//        return "PropertyType{" +
//                "apartment='" + apartment + '\'' +
//                ", house='" + house + '\'' +
//                ", townhouse='" + townhouse + '\'' +
//                '}';
//    }
//
//    public static class Builder {
//        String apartment;
//        String house;
//        String townhouse;
//
//        public Builder setApartment(String apartment) {
//            this.apartment = apartment;
//            return this;
//        }
//
//        public Builder setHouse(String house) {
//            this.house = house;
//            return this;
//        }
//
//        public Builder setTownhouse(String townhouse) {
//            this.townhouse = townhouse;
//            return this;
//        }
//
//        public Builder copy(PropertyType propertyType){
//            this.apartment = propertyType.apartment;
//            this.house = propertyType.house;
//            this.townhouse = propertyType.townhouse;
//            return this;
//        }
//
//        public PropertyType build(){
//            return new PropertyType(this);
//        }
//    }
//}
