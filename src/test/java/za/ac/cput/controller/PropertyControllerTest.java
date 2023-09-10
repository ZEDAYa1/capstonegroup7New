/*
 * PropertyControllerTest.java
 * This is the test class for PropertyController
 * Author: Tshegofatso Molefe {219001235}
 * Date: 5 September 2023
 * */

package za.ac.cput.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PropertyControllerTest {
    private static Property property = PropertyFactory.createProperty("10 Varsity Street, Belhar, 7493", 5600.0,
            "Spacious, Well maintained, close to shops and schools");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/property";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Property> postResponse = restTemplate.postForEntity(url, property, Property.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Property createdProperty = postResponse.getBody();
        System.out.println("Saved data "+ createdProperty);
        assertEquals(property.getPropertyID(), createdProperty.getPropertyID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + property.getPropertyID();
        System.out.println("URL: " + url);
        ResponseEntity<Property> response = restTemplate.getForEntity(url, Property.class);
        assertEquals(property.getPropertyID(), response.getBody().getPropertyID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Property updated = new Property.Builder().copy(property).setRentAmount(5690.00).build();
        String url = baseURL + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Property> response = restTemplate.postForEntity(url, updated, Property.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete" + property.getPropertyID();
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
