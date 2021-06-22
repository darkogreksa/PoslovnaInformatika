package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsername(String username);

}
