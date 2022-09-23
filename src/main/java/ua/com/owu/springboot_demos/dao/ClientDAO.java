package ua.com.owu.springboot_demos.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.springboot_demos.models.Client;

public interface ClientDAO extends JpaRepository<Client, Integer> {

    Client findByUsername(String username);

}
