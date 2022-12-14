package com.example.asmspringboot2.entity.dto;

import com.example.asmspringboot2.entity.entityEnum.UserRole;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    private long id;
    @NotEmpty(message = "Fullname cannot be empty")
    private String fullName;
    private String avatar;
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotEmpty(message = "Phone cannot be empty")
    private String phone;
    @NotEmpty(message = "Address cannot be empty")
    private String address;
    private UserRole role;
}