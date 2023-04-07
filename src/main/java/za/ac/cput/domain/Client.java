/*
 * Client.java
 * This is the client entity
 * Author: Tshegofatso Molefe {219001235}
 * Date: 6 April 2023
 * */
package za.ac.cput.domain;

import java.util.Objects;
public class Client {
    private String clientID;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;

    private Client(){
    }

    public Client(Builder builder) {
        this.clientID = builder.clientID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;
    }

    public String getClientID() {
        return clientID;
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
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientID, client.clientID) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(email, client.email) && Objects.equals(mobileNumber, client.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID, firstName, lastName, email, mobileNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
    //Builder Pattern

    public static class Builder{
        private String clientID, firstName, lastName, email, mobileNumber;

        public Builder setClientID(String clientID) {
            this.clientID = clientID;
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

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder copy(Client client){
            this.clientID = client.clientID;
            this.firstName = client.firstName;
            this.lastName = client.lastName;
            this.email = client.email;
            this.mobileNumber = client.mobileNumber;
            return this;
        }

        public Client build(){
            return new Client(this);
        }
    }
}
