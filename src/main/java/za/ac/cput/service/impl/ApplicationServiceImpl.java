/* ApplicationServiceImpl.java
 *  This is a service implementation class for Application entity.
 *  Zachariah Matsimella 220097429
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Application;
import za.ac.cput.repository.IApplicationRepository;
import za.ac.cput.service.ApplicationService;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final IApplicationRepository repository;

    @Autowired
    ApplicationServiceImpl(IApplicationRepository repository){
        this.repository = repository;
    }

    @Override
    public Application save(Application application) {
        return this.repository.save(application);
    }

    @Override
    public Application read(String applicationId) {
        return this.repository.findById(applicationId).orElse(null);
    }

    @Override
    public Application update(Application application) {
        if (this.repository.existsById(application.getPropertyId())) {
            return this.repository.save(application);
        }
        return null;
    }

    @Override
    public boolean delete(String applicationId) {
        if (this.repository.existsById(applicationId)) {
            this.repository.deleteById(applicationId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Application> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
