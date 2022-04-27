package ua.com.owu.springboot_demos.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerSizeExceptionDTO {
    private int code;
    private String field;
    private String msg;
}
