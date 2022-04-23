package ua.com.owu.springboot_demos.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private AuthenticationManager authenticationManager;

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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CustomerDTO customerDTO) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customerDTO.getUsername(), customerDTO.getPassword()));
        if (authenticate != null) {
            String jwtoken = Jwts.builder()
                    .setSubject(authenticate.getName())
                    .signWith(SignatureAlgorithm.HS512, "okten".getBytes())
                    .compact();
            System.out.println(jwtoken);


            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + jwtoken);
            return new ResponseEntity<>("you are log in", headers, HttpStatus.OK);
        }
        return new ResponseEntity<>("you are log in", HttpStatus.FORBIDDEN);

    }
}
