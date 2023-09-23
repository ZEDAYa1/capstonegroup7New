/*
 * AgentFactory.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.factory;

import za.ac.cput.domain.Agent;
import za.ac.cput.util.Helper;

public class AgentFactory {

    public static Agent createAgent(String agentId, String firstname, String lastname, String contactnumber,String email, String password, String address){
        Helper.checkStringParam("agentId", agentId);
        Helper.checkStringParam("firstname", firstname);
        Helper.checkStringParam("lastname", lastname);
        Helper.checkStringParam("contactnumber", contactnumber);
        Helper.checkStringParam("email", email);
        Helper.checkStringParam("password", password);
        Helper.checkStringParam("address", address);

        return new Agent.Builder().setAgentId(agentId)
                .setFirstname(firstname)
                .setLastname(lastname)
                .setContactnumber(contactnumber)
                .setEmail(email)
                .setPassword(password)
                .setAddress(address)
                .build();


    }

}