package com.trashsmart.trash_smart_api.web;


import com.trashsmart.trash_smart_api.entities.AppUser;
import com.trashsmart.trash_smart_api.repositories.AppRoleRepository;
import com.trashsmart.trash_smart_api.repositories.AppUserRepository;
import com.trashsmart.trash_smart_api.security.JwtUtil;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody @Valid RegisterRequest request) {
        AppUser user = AppUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .roles(Set.of(appRoleRepository.findByRoleName("ROLE_USER")))
                .build();
        appUserRepository.save(user);
        return Map.of("message", "User registered");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody @Valid LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        String token = jwtUtil.generateToken(request.getUsername());
        return Map.of("token", token);
    }
}

