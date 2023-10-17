/*
 * AgentFactoryTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserFactoryTest {
    @Test
    void test() {
        User user = UserFactory.createUser("sibusiso", "sibusiso@example.com", "password123");
        System.out.println(user.toString());
        assertNotNull(user);
    }

    @Test
    void test_fail() {
        User user = UserFactory.createUser( "", "sibusiso@example.com", "password123");
        System.out.println(user.toString());
        assertNotNull(user);
    }

    @Test
    public void test_equality() {
        User user1 = UserFactory.createUser("sibusiso",  "sibusiso@example.com", "password123");
        User user2 = UserFactory.createUser("dwayi", "sibusiso@example.com", "password123");
        assertEquals(user1, user2);
    }

    @Test
    public void timeOutTest() {
        User user1 = UserFactory.createUser("sibusiso123", "sibusiso@example.com", "password123");
        try {
            Thread.sleep(1500);
            assertEquals(user1.getUserId(), user1.getUserId());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
