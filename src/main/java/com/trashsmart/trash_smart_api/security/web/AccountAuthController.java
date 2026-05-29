package com.trashsmart.trash_smart_api.security.web;


import com.trashsmart.trash_smart_api.security.dtos.JwtResponse;
import com.trashsmart.trash_smart_api.security.dtos.LoginRequest;
import com.trashsmart.trash_smart_api.security.dtos.RegisterRequest;
import com.trashsmart.trash_smart_api.security.entities.AppRole;
import com.trashsmart.trash_smart_api.security.entities.AppUser;
import com.trashsmart.trash_smart_api.security.filters.JwtUtil;
import com.trashsmart.trash_smart_api.security.services.AccountAuthService;
import com.trashsmart.trash_smart_api.security.utils.RoleUserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "Bearer Authentication")
public class AccountAuthController {
    private final AccountAuthService accountAuthService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterRequest registerRequest) {

        // 1. On transfère uniquement les données sécurisées du DTO vers l'entité
        AppUser newUser = new AppUser();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(registerRequest.getPassword());

        // On force l'activation du compte par défaut côté serveur
        newUser.setEnabled(true);

        // 2. On sauvegarde l'utilisateur (le service va hacher le mot de passe)
        AppUser savedUser = accountAuthService.addUser(newUser);

        // 3. On lui donne le rôle de base automatiquement
        accountAuthService.addRoleToUser(savedUser.getUsername(), "USER");

        return savedUser;
    }

   /* @PostMapping("/register")
    public AppUser register(@RequestBody AppUser appUser){
        return accountAuthService.addUser(appUser);
    }*/
    @GetMapping("/user/{username}")
    public AppUser discoverUserByUsername(@PathVariable String username) {
        return accountAuthService.getUserByUsername(username);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        AppUser appUser = accountAuthService.getUserByUsername(loginRequest.getUsername());
        if (appUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur non trouvé");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), appUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect");
        }

        String token = jwtUtil.generateToken(
                appUser.getUsername(),
                appUser.getRoles().stream()
                        .map(role -> (GrantedAuthority) new SimpleGrantedAuthority(role.getRoleName())).toList()
        );

        // String token = jwtUtil.generateToken(appUser.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }


    @GetMapping("/users")
    public List<AppUser> getAppUsers(){
       return accountAuthService.appUsersList();
    }
    @PostMapping("/users")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountAuthService.addUser(appUser);
    }
    @PostMapping("/roles")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return accountAuthService.addRole(appRole);
    }
    @PostMapping("/addRoleToUser")
    public void assignRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountAuthService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        accountAuthService.deleteUserById(id);
    }


}

