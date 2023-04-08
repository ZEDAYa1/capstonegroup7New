/*
 * ClientRepositoryTest.java
 * This is the test for the client repository
 * Author: Tshegofatso Molefe {219001235}
 * Date: 8 April 2023
 * */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Client;
import za.ac.cput.factory.ClientFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ClientRepositoryTest {
    private static ClientRepository repository = ClientRepository.getRepository();
    private static Client client = ClientFactory.createClient("Tshego", "Molefe", "tshego@email.com", "0213568978");
    @Test
    void a_create() {
        Client created = repository.create(client);
        assertNotNull(client.getClientID(), created.getClientID());
        System.out.println(created);
    }

    @Test
    void b_read() {
        Client read = repository.read(client.getClientID());
        assertNotNull(read);
        System.out.println(read);

    }

    @Test
    void c_update() {
        Client updated = new Client.Builder().copy(client).setEmail("Name@email.com")
                .setMobileNumber("0812345678")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updates :" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(client.getClientID());
        assertTrue(success);
        System.out.println("Deleted :" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all clients");
        System.out.println(repository.getAll());
    }
}