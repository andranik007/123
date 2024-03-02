package com.example.gg.Controller;

import com.example.gg.Dto.UserDto;
import com.example.gg.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor

public class AuthController {

    private final UserService userService;

    @GetMapping
    public String registerForm(UserDto userDto){
        return "/registration";
    }

    @PostMapping
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration";
        }
        userService.registration(userDto);
        return "redirect:/login";
    }
}
