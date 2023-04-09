/* ComplaintFactoryTest.java
 Author: Sibusiso Dwayi(220226466)
 Date: 8 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Complaint;

import static org.junit.jupiter.api.Assertions.*;

class ComplaintFactoryTest {

    @Test
    void test() {
        Complaint complaint = ComplaintFactory.createComplaint("There were cockroaches in the cupboards","03/04/2023","Pending");
        System.out.println(complaint.toString());
        assertNotNull(complaint);
    }
    @Test
    void test_fail(){
        Complaint complaint =ComplaintFactory.createComplaint("There were cockroaches in the cupboards","","Pending");
        System.out.println(complaint.toString());
        assertNotNull(complaint);
    }
}