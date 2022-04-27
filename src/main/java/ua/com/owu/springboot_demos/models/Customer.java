package ua.com.owu.springboot_demos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "name is required")
    @Size(min = 2, message = "name must be at least 2 characters")
    @Size(max = 255, message = "name must 255 chars max")
    private String name;
    private String password;
    private int age;

    public Customer() {
    }
}
