package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Employee;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.UserAuthority;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);

        if (employee == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            for (UserAuthority ua: employee.getUserAuthorities()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(ua.getAuthority().getName()));
            }

            return new org.springframework.security.core.userdetails.User(
                    employee.getUsername(),
                    employee.getPassword(),
                    grantedAuthorities);
        }
    }
}
