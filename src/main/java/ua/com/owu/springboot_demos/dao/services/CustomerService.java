package ua.com.owu.springboot_demos.dao.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.owu.springboot_demos.dao.CustomerDAO;
import ua.com.owu.springboot_demos.models.dto.CustomerDTO;
import ua.com.owu.springboot_demos.models.entity.Customer;

@Service
@AllArgsConstructor
public class CustomerService {

    private PasswordEncoder passwordEncoder;
    private CustomerDAO customerDAO;

    public void save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setLogin(customerDTO.getUsername());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customer.setRole("ROLE_ADMIN");
        customerDAO.save(customer);

    }

    public Customer findCustomerByLogin(String login) {
        return customerDAO.findCustomerByLogin(login);

    }
}
