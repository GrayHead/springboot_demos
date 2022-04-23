package ua.com.owu.springboot_demos.models.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private String username;
    private String password;
}
