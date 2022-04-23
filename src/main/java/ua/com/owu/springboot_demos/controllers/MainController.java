package ua.com.owu.springboot_demos.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.owu.springboot_demos.dao.services.CustomerService;
import ua.com.owu.springboot_demos.models.dto.CustomerDTO;

@RestController
@AllArgsConstructor
public class MainController {

    private CustomerService customerService;

    @GetMapping("/open")
    public String open() {
        return "open url";
    }


    @GetMapping("/secure")
    public String secure() {
        return "secure url";
    }

    @PostMapping("/save")
    public void save(@RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO);
    }
}
