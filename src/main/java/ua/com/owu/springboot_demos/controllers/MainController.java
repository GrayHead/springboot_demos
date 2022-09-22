package ua.com.owu.springboot_demos.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @PostMapping("/token")
    public String createToken(@RequestParam String username, @RequestParam String password) {
        String jwtoken = Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, password.getBytes())
                .compact();
        System.out.println(jwtoken);
        return jwtoken; // токен містть дані про юзернейм закодований паролем. Отримати нейм можливо тільки знаючи пароль
    }


}
