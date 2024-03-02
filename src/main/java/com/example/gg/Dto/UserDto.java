package com.example.gg.Dto;

import com.example.gg.Entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private Long id;

    @NotBlank(message = "Поле не может быть пустым!")
    @Size(max = 10, min = 2, message = "Допустимая длина от 2 до 10 символов")
    @Pattern(regexp = "[A-z]", message = "Может содержать только символы от A до Z")
    private String fio;

    @NotBlank
    @Pattern(regexp = "A-Za-z{0,9}", message = "НЕ НЕ НЕ ")
    private String email;

    @NotBlank
    @Pattern(regexp = "[0,9]", message = "НЕ НЕ НЕ ")
    private String phone;

    private String login;
    private String password;
    private Set<Role> roles;
}
