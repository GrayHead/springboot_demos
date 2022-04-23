package ua.com.owu.springboot_demos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.springboot_demos.models.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    Customer findCustomerByLogin(String login);

}
