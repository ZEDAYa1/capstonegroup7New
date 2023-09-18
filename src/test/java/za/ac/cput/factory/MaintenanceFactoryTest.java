package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Maintenance;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceFactoryTest {

    @Test
    public void test(){
        Maintenance maintenance=MaintenanceFactory.createMaintenance("mould", maintenance.getPropertyID(), maintenance.getDescription(), LocalDate.parse("2022-02-19"));
        System.out.println(maintenance.toString());
        assertNotNull(maintenance);


    }
    @Test
    public void test_fail(){
        Maintenance maintenance= MaintenanceFactory.createMaintenance("mould", maintenance.getPropertyID(), maintenance.getDescription(), LocalDate.parse("2022-02-19"));
        System.out.println(maintenance.toString());
        assertNotNull(maintenance);

    }
    @Test
    public void testEquality(){
     Maintenance m1 =MaintenanceFactory.createMaintenance("mould", maintenance.getPropertyID(), maintenance.getDescription(), LocalDate.parse("2022-02-19"));
     Maintenance m2=m1;
     assertEquals(m1, m2);

    }


    @Test
    public void testIdentity(){
        Maintenance ma1=MaintenanceFactory.createMaintenance("mould", maintenance.getPropertyID(), maintenance.getDescription(), LocalDate.parse("2022-02-19"));
        Maintenance ma2=MaintenanceFactory.createMaintenance("mould", maintenance.getPropertyID(), maintenance.getDescription(), LocalDate.parse("2022-02-19"));
        assertNotSame(ma1, ma2);

    }


    @Test
    @Timeout(value = 200,unit = TimeUnit.MILLISECONDS)
    public void testTimeout(){
        System.out.println("Timeout passed");


    }


    @Test
    @Disabled
    public void testdisabled() {

        System.out.println("test disabled");
    }

}








