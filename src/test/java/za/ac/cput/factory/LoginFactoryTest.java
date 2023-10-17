/*
 * AgentFactoryTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoginFactoryTest {
    @Test
    void test() {
        Login login = LoginFactory.createLogin("sibusiso", "password123");
        System.out.println(login.toString());
        assertNotNull(login);
    }

    @Test
    void test_fail() {
        Login login = LoginFactory.createLogin("", "password123");
        System.out.println(login.toString());
        assertNotNull(login);
    }

    @Test
    public void test_equality() {
        Login login1 = LoginFactory.createLogin("sibusiso", "password123");
        Login login2 = LoginFactory.createLogin("sibusiso", "password123");
        assertEquals(login1, login2);
    }

    @Test
    @Timeout(1) // Seconds
    public void timeOutTest() {
        Login login = LoginFactory.createLogin("sibusiso", "password123");
        try {
            Thread.sleep(600);
            assertEquals(login.getUsername(), login.getUsername());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

