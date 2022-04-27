package ua.com.owu.springboot_demos.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.com.owu.springboot_demos.models.Customer;
import ua.com.owu.springboot_demos.models.dto.CustomerDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CustomerUtil {

    public List<CustomerDTO> convertCustomerToDTO(List<Customer> customerList) {
        List<CustomerDTO> collect = customerList
                .stream()
                .map(customer -> new CustomerDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getAge()))
                .collect(Collectors.toList());
        return collect;
    }

    public CustomerDTO convertCustomerToDTO(Customer customer) {
        return new CustomerDTO(customer.getId(),customer.getName(), customer.getAge());

    }

    public Customer dtoToCustomer(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getCustomerName());
        customer.setAge(dto.getCustomerAge());
        return customer;

    }

}
