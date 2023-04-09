package za.ac.cput.repository;
import za.ac.cput.domain.maintenance;
import java.util.Set;
public interface imaintenanceRepository extends iRepository<maintenance,String> {
//create,read,update,delete
public Set<maintenance> getAll();
}
