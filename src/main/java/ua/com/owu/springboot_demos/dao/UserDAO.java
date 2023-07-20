package ua.com.owu.springboot_demos.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.com.owu.springboot_demos.models.User;

public interface UserDAO extends MongoRepository<User, String> {
}
