/*
 * Agent.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.domain;

public class Agent {
    private String agentId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String password;
    private String address;
    private String agencyId;
    private Agent(){

    }
    private Agent(AgentBuilder builder){
        this.agentId = builder.agentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
        this.password = builder.password;
        this.address = builder.agencyId;
    }

    public String getAgentId() {
        return agentId;
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

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getAgencyId() {
        return agencyId;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId='" + agentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", agencyId='" + agencyId + '\'' +
                '}';
    }
    public static class AgentBuilder{
        private String agentId;
        private String firstName;
        private String lastName;
        private String contactNumber;
        private String email;
        private String password;
        private String address;
        private String agencyId;

        public AgentBuilder setAgentId(String agentId) {
            this.agentId = agentId;
            return this;
        }

        public AgentBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AgentBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AgentBuilder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public AgentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public AgentBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public AgentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public AgentBuilder setAgencyId(String agencyId) {
            this.agencyId = agencyId;
            return this;
        }
        public AgentBuilder copy(Agent agent){
            this.agentId = agent.agentId;
            this.firstName = agent.firstName;
            this.lastName = agent.lastName;
            this.contactNumber = agent.contactNumber;
            this.email = agent.email;
            this.password = agent.password;
            this.address = agent.agencyId;
            return this;
        }
        public Agent build(){
            return new Agent(this);
        }
    }
    }
