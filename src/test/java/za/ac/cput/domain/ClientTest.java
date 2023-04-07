/*
 * ClientTest.java
 * This is the test for the client entity
 * Author: Tshegofatso Molefe {219001235}
 * Date: 7 April 2023
 * */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.ClientFactory;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    @Test
    public void test(){
    Client client = new Client.Builder()
            .setFirstName("Firstname")
            .setLastName("Lastname")
            .setMobileNumber("0895623265")
            .build();
        System.out.println(client.toString());
        assertNotNull(client);
    }

    @Test
    public void test2(){
        Client client = ClientFactory.createClient("firstName", "lastName", "email@address.com", "0213564856");
        System.out.println(client.toString());
        assertNotNull(client);
    }

    @Test
    public void failTest(){

    }

}