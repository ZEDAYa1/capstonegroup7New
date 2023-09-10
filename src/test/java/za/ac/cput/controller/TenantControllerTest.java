/*
 * TenantControllerTest.java
 * This is the test class for TenantController
 * Author: Tshegofatso Molefe {219001235}
 * Date: 5 September 2023
 * */
package za.ac.cput.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
class TenantControllerTest {
    private static Tenant tenant = TenantFactory.createTenant("Tshego", "Molefe", "tshegomolefe@email.com", "0818006416");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/tenant";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Tenant> postResponse = restTemplate.postForEntity(url, tenant, Tenant.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Tenant createdTenant = postResponse.getBody();
        System.out.println("Saved data "+ createdTenant);
        assertEquals(tenant.getTenantID(), createdTenant.getTenantID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + tenant.getTenantID();
        System.out.println("URL: " + url);
        ResponseEntity<Tenant> response = restTemplate.getForEntity(url, Tenant.class);
        assertEquals(tenant.getTenantID(), response.getBody().getTenantID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Tenant updated = new Tenant.Builder().copy(tenant).setContactNumber("0794024391").build();
        String url = baseURL + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Tenant> response = restTemplate.postForEntity(url, updated, Tenant.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete" + tenant.getTenantID();
        System.out.println("URL: "+ url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
