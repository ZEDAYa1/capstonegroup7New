package za.ac.cput.domain;

public class Address {
    String streetNum;
    String streetName;
    String city;
    String province;

    public Address(){

    }
    public Address(String streetNum, String streetName, String city, String province) {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
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
}
