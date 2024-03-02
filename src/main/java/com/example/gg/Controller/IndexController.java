package com.example.gg.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor

public class IndexController {

    @PostAuthorize("hasRole('/ADMIN')")
    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}
