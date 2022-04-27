package ua.com.owu.springboot_demos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
//@Table(name = "customer_table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    @Column(name = "customer_name", unique = true, nullable = false)
    private String name;

    public Customer() {
    }
}
