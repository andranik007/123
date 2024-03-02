package com.example.gg.Service;

import com.example.gg.Dto.UserDto;
import com.example.gg.Entity.Role;
import com.example.gg.Entity.User;
import com.example.gg.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public void registration(UserDto userDto){
        User user = new User();
        user.setFio(userDto.getFio());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
    }
}
