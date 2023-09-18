package za.ac.cput.factory;

//sonwabiso Moni
//219275041

import za.ac.cput.domain.Maintenance;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class MaintenanceFactory {


    public static Maintenance createMaintenance(String description, String propertyID, String maintenanceDescription, LocalDate requestDate) {
        if (Helper.isNullOrEmpty(String.valueOf(description)) || Helper.isNullOrEmpty(String.valueOf(requestDate)))
            return null;

        String requestId = Helper.generateId();
        String propertyId = Helper.generateId();

        Maintenance maintenance = new Maintenance.Builder()
                .setDescription(description)
                .setRequestId(requestId)
                .setRequestDate(requestDate)
                .setPropertyID(propertyId)
                .build();
        return maintenance;


    }
}
