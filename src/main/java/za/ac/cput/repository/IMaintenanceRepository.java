package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Maintenance;

//sonwabiso Moni
//219275041

@Repository
public interface IMaintenanceRepository extends JpaRepository<Maintenance,String> {
//create,read,update,delete
    //public Set<Maintenance> getAll();
}
