package com.example.projjet.SecurityServices;

import com.example.projjet.model.Employee;
import com.example.projjet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {
@Autowired
    private EmployeeRepository employeeRepository;
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee=employeeRepository.findByMail(username).get(0);
        CustomUserDetails userDetails = null;
        if(employee!=null){
            userDetails=new CustomUserDetails();
            userDetails.setEmployee(employee);
        }else {
            throw new UsernameNotFoundException("employee not exist with name:"+username);
        }
        return userDetails;
    }
}
