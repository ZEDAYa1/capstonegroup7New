/*
 * AgentFactory.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.factory;

import za.ac.cput.domain.Agent;
import za.ac.cput.util.Helper;

public class AgentFactory {

    public static Agent createAgent(String firstName, String lastName, String contactNumber, String email, String password, String address){
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(contactNumber) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(address)) {
            return null;
        }
        if (!Helper.isValidEmail(email)) {
            return null;
        }
        String agentId = Helper.generateId();
        String agencyId = Helper.generateId();

        return new Agent.Builder().setAgentId(agentId)
                .setFirstname(firstName)
                .setLastname(lastName)
                .setContactnumber(contactNumber)
                .setEmail(email)
                .setPassword(password)
                .setAddress(address)
                //.setAgencyId(agencyId)
                .build();

    }
}
