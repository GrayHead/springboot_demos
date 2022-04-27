package ua.com.owu.springboot_demos.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.owu.springboot_demos.dao.CustomerDAO;
import ua.com.owu.springboot_demos.models.Customer;
import ua.com.owu.springboot_demos.models.dto.CustomerDTO;
import ua.com.owu.springboot_demos.utils.CustomerUtil;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerDAO customerDAO;
    private CustomerUtil customerUtil;


    public List<CustomerDTO> findAll() {
        return customerUtil.convertCustomerToDTO(customerDAO.findAll());
    }

    public CustomerDTO findOneById(int id) {
        return customerUtil.convertCustomerToDTO(customerDAO.findById(id).get());
    }

    public void save(CustomerDTO customerDTO) {
        customerDAO.save(customerUtil.dtoToCustomer(customerDTO));
    }

    public void delete(int id) {
        customerDAO.deleteById(id);
    }

    public CustomerDTO update(CustomerDTO dto) {
        return customerUtil
                .convertCustomerToDTO(
                        customerDAO.save(customerUtil.dtoToCustomer(dto))
                );

    }
}
