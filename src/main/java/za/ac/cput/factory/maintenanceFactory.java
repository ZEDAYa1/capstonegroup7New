package za.ac.cput.factory;

//sonwabiso Moni
//219275041

import za.ac.cput.domain.maintenance;
import za.ac.cput.util.Helper;
public class maintenanceFactory {


    public static maintenance createmaintenance(String Location, String TenantName, String Address, String HouseNr) {
        if (Helper.isNullOrEmpty(TenantName) || Helper.isNullOrEmpty(Address))
            return null;
        ;
        String MaintenanceID = Helper.generateId();
        maintenance maintenance = new maintenance.Builder().setAddress(Address)
                .setMaintenanceID(MaintenanceID)
                .setHouseNr(HouseNr)
                .setLocation(Location)
                .setTenantName(TenantName)
                .build();
        return maintenance;


    }
}
