package ua.com.owu.springboot_demos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.springboot_demos.models.Customer;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where c.name=:name")
    List<Customer> byName(@Param("name") String xxx);

    List<Customer> findByName(String name);

}

//https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
