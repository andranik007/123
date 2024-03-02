package com.example.gg.Controller;

import com.example.gg.Dto.UserDto;
import com.example.gg.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequiredArgsConstructor

public class WebController implements WebMvcConfigurer {

    private final UserService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
    }

    @GetMapping("/")
    public String showForm(UserDto userDto){return "form";}

    @PostMapping
    public String checkUserInfo(@Valid UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/recults";
    }

}
