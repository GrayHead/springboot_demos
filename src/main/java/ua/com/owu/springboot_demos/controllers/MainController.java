package ua.com.owu.springboot_demos.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.springboot_demos.dao.CustomerDAO;
import ua.com.owu.springboot_demos.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class MainController {

    private CustomerDAO customerDAO;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> all = customerDAO.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        Optional<Customer> byId = customerDAO.findById(id);
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public void saveCustomerJSONBody(@RequestBody Customer customer) {
        customerDAO.save(customer);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable int id) {
        customerDAO.deleteById(id);
        return new ResponseEntity<>(customerDAO.findAll(), HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer) {
        customerDAO.save(customer);
        return new ResponseEntity<>(customerDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findby/name/{name}")
    public List<Customer> findByNameQuery(@PathVariable String name) {
        return customerDAO.byName(name);
    }

    @GetMapping("/findby/name/method/{name}")
    public List<Customer> findByNameMethod(@PathVariable String name) {
        return customerDAO.findByName(name);
    }


}
