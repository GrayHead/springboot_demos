package ua.com.owu.springboot_demos.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.owu.springboot_demos.dao.UserDAO;
import ua.com.owu.springboot_demos.models.User;

@RestController
@AllArgsConstructor
public class MainController {
    private UserDAO userDAO;
    @PostMapping("/users")
    public void saveUser (@RequestBody User user) {

        userDAO.save(new User());
    }
}
