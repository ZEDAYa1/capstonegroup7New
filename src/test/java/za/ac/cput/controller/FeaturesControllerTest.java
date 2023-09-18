package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Features;
import za.ac.cput.factory.FeaturesFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FeaturesControllerTest {
private static Features features= FeaturesFactory.buildFeatures("outdoor",true,true,55,5,5,true,true);


    @Autowired
    private FeaturesController controller;

    @Autowired private TestRestTemplate testRestTemplate;
    private final String baseURL="http://localhost:8080/features";






    @Test
    void create() {
        String url=baseURL+"/create";
        ResponseEntity<Features> postResponse=testRestTemplate.postForEntity(url,features,Features.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Features createdFeatures= postResponse.getBody();
        System.out.println("Saved data"+createdFeatures);
        assertEquals(features.getPropertyID(),createdFeatures.getPropertyID());

    }

    @Test
    void delete() {
        String url = baseURL + "/delete/" + features.getPropertyID();
        System.out.println("URL: " + url);
        testRestTemplate.delete(url);



    }

    @Test
    void getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());


    }
}