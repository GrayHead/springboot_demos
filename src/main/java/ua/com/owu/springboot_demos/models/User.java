package ua.com.owu.springboot_demos.models;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}
