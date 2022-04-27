package ua.com.owu.springboot_demos.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private int id;
    private String customerName;
    private int customerAge;

    public CustomerDTO(String customerName, int customerAge) {
        this.customerName = customerName;
        this.customerAge = customerAge;
    }
}
