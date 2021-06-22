package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Employee;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee findByUsername (String username) {
        return employeeRepository.findByUsername(username);
    }

}
