/* LeaseController.java
 *  This is a domain class for Lease entity
 *  Zachariah Matsimella 220097429
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Lease;
import za.ac.cput.service.LeaseService;

import java.util.Set;

@RestController
@RequestMapping("/leases") // Base URL mapping for the Lease service
public class LeaseController {

    private final LeaseService leaseService;

    @Autowired
    public LeaseController(LeaseService leaseService) {
        this.leaseService = leaseService;
    }

    @PostMapping("save")
    public Lease saveLease(@RequestBody Lease lease) {
        return leaseService.save(lease);
    }

    @GetMapping("read/{id}")
    public Lease getLease(@PathVariable String id) {
        return leaseService.read(id);
    }

//    @PostMapping("/update/{leaseID}")
//    public Lease updateLease(@PathVariable String id, @RequestBody Lease lease) {
//        lease.setLeaseId(leaseID);
//        return leaseService.update(lease);
//    }

    @DeleteMapping("delete/{id}")
    public boolean deleteLease(@PathVariable String id) {
        return leaseService.delete(id);
    }

    @GetMapping("all")
    public Set<Lease> findAllLeases() {
        return leaseService.findAll();
    }
}
