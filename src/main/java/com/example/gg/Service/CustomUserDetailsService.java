package com.example.gg.Service;

import com.example.gg.Entity.User;
import com.example.gg.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        User user = userRepo.findByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("Пользовател не найден:" + login);
        }
        List<SimpleGrantedAuthority> authorityList = user.getRoles().stream().map(
                role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorityList);
    }
}
