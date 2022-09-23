package ua.com.owu.springboot_demos.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.owu.springboot_demos.dao.ClientDAO;
import ua.com.owu.springboot_demos.models.Client;

@RestController
@AllArgsConstructor
public class MainController {
    private PasswordEncoder passwordEncoder;
    private ClientDAO clientDAO;

    @PostMapping("/token")
    public String createToken(@RequestParam String username, @RequestParam String password) {
        //Стоірили токен
        String jwtoken = Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, "okten".getBytes())
                .compact();

        Client client = Client.builder()
                .username(username)
                // захешували пароль
                .password(passwordEncoder.encode(password))
                .token(jwtoken)
                .build();
        //Збергли об'єкт в якому є токен,
        // котрий містить нейм та розшифровується за допомоши паролю
        clientDAO.save(client);
        return jwtoken;
    }

    //    тестовий захищений метод
    @GetMapping("/testCheck")
    public String testCheck() {
        return "test";
    }

    @GetMapping("/secure")
    public String secure () {
            return "secure data";
    }


}
