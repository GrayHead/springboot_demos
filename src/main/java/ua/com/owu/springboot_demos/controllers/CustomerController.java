package ua.com.owu.springboot_demos.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.springboot_demos.dao.CustomerDAO;
import ua.com.owu.springboot_demos.models.Customer;
import ua.com.owu.springboot_demos.models.dto.CustomerDTO;
import ua.com.owu.springboot_demos.services.CustomerService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable int id) {
        return new ResponseEntity<>(customerService.findOneById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public void saveCustomerJSONBody(@RequestBody @Valid CustomerDTO customerDTO) {
        customerService.save(customerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable int id) {
        customerService.delete(id);

    }

    @PatchMapping("")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO dto) {
        return new ResponseEntity<>(customerService.update(dto), HttpStatus.OK);
    }

//    @GetMapping("/findby/name/{name}")
//    public List<Customer> findByNameQuery(@PathVariable String name) {
//        return customerDAO.byName(name);
//    }
//
//    @GetMapping("/findby/name/method/{name}")
//    public List<Customer> findByNameMethod(@PathVariable String name) {
//        return customerDAO.findByName(name);
//    }


}
