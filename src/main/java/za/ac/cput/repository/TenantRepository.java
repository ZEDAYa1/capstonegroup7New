package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Tenant;

import java.util.HashSet;
import java.util.Set;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, String>
{
}
