package za.ac.cput.repository;
import java.util.HashSet;
import java.util.Set;


import za.ac.cput.domain.maintenance;
public class maintenanceRepository implements imaintenanceRepository{

private static maintenanceRepository repository=null;
private Set<maintenance> maintenanceDB=null;

private maintenanceRepository(){maintenanceDB=new HashSet<maintenance>();}
public static maintenanceRepository getRepository(){
if (repository==null){
  repository= new maintenanceRepository();

}
  return repository;
}

@Override
public maintenance create(maintenance maintenance){
 boolean success=maintenanceDB.add(maintenance);
 if(!success)
     return null;
 return maintenance;



}
   @Override
  public maintenance read(String maintenanceID){
  maintenance maintenance=maintenanceDB.stream()
          .filter(m->m.getMaintenanceID().equals(maintenanceID))
          .findAny()
          .orElse(null);
          return maintenance;


  }
    @Override
    public maintenance update(maintenance maintenance) {
        maintenance oldmaintenance = read(maintenance.getMaintenanceID());
        if (oldmaintenance != null) {
            maintenanceDB.remove(oldmaintenance);
            maintenanceDB.add(maintenance);
            return maintenance;

        }

return null;
    }

    @Override
    public boolean delete(String maintenanceID) {
        maintenance maintenanceToDelete = read(maintenanceID);
        if(maintenanceToDelete == null)
            return false;
        maintenanceDB.remove(maintenanceToDelete);
        return true;
    }
    @Override
    public Set<maintenance> getAll() {
        return maintenanceDB;
    }



}
