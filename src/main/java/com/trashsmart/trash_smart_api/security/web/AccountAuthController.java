package com.trashsmart.trash_smart_api.security.web;


import com.trashsmart.trash_smart_api.security.entities.AppRole;
import com.trashsmart.trash_smart_api.security.entities.AppUser;
//import com.trashsmart.trash_smart_api.security.filters.JwtUtil;
import com.trashsmart.trash_smart_api.security.filters.JwtUtil;
import com.trashsmart.trash_smart_api.security.repository.AppRoleRepository;
import com.trashsmart.trash_smart_api.security.repository.AppUserRepository;
import com.trashsmart.trash_smart_api.security.services.AccountAuthService;
import com.trashsmart.trash_smart_api.security.utils.RoleUserForm;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AccountAuthController {
     private final AppUserRepository appUserRepository;
     private final AppRoleRepository appRoleRepository;
     private final AuthenticationManager authenticationManager;
      private final PasswordEncoder passwordEncoder;
     private final JwtUtil jwtUtil;
    AccountAuthService accountAuthService;

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

    // private final AppUserRepository appUserRepository;
   // private final AppRoleRepository appRoleRepository;
   // private final AuthenticationManager authenticationManager;
  //  private final PasswordEncoder passwordEncoder;
   // private final JwtUtil jwtUtil;

   /* public AccountAuthController(AppUserRepository appUserRepository,
                                 AppRoleRepository appRoleRepository,
                                 AuthenticationManager authenticationManager,
                                 PasswordEncoder passwordEncoder,
                                 JwtUtil jwtUtil) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }*/

  /*  @PostMapping("/register")
    public Map<String, String> register(@RequestBody @Valid RegisterRequest request) {
        AppUser user = AppUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .roles(Set.of(appRoleRepository.findByRoleName("ROLE_USER")))
                .build();
        appUserRepository.save(user);
        return Map.of("message", "User registered");
    }*/

  /*  @PostMapping("/login")
    public Map<String, String> login(@RequestBody @Valid LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        String token = jwtUtil.generateToken(request.getUsername());
        return Map.of("token", token);
    }*/
}

