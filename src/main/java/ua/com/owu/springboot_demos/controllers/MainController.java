package ua.com.owu.springboot_demos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.springboot_demos.models.Customer;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    List<Customer> customerList = new ArrayList<>();

    public MainController() {
        customerList.add(new Customer(1, "vasya1"));
        customerList.add(new Customer(2, "vasya2"));
        customerList.add(new Customer(3, "vasya3"));
        customerList.add(new Customer(4, "vasya4"));

    }

    // localhost:8080/  [GET]
    @GetMapping("/")
    public ResponseEntity<String> homeGet() {
        return new ResponseEntity<>("home get", HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> homePost() {
        return new ResponseEntity<>("home post", HttpStatus.CREATED);
    }


    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(this.customerList, HttpStatus.OK);
    }

//    @GetMapping("/customers")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Customer> getCustomers() {
//        return this.customerList;
//    }


//    @PostMapping("/customers")
//    public ResponseEntity<List<Customer>> saveCustomer(
//            @RequestParam int id,
//            @RequestParam String name
//    ) {
//        this.customerList.add(new Customer(id, name));
//        return new ResponseEntity<>(this.customerList, HttpStatus.CREATED);
//
//    }


    @PostMapping("/customers")
    public void saveCustomerJSONBody(@RequestBody Customer customer) {
        customerList.add(customer);
        System.out.println(customerList);

    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable int id) {
        customerList.removeIf(customer -> customer.getId() == id);
        return new ResponseEntity<>(customerList, HttpStatus.ACCEPTED);
    }



}
