package com.trashsmart.trash_smart_api.services;

import com.trashsmart.trash_smart_api.entities.AppRole;
import com.trashsmart.trash_smart_api.entities.AppUser;
import com.trashsmart.trash_smart_api.repositories.AppRoleRepository;
import com.trashsmart.trash_smart_api.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AppUser addUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    @Override
    public AppRole addRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole role = appRoleRepository.findByRoleName(roleName);
        AppUser user = appUserRepository.findByUsername(username);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return appUserRepository.findByUsername(username);

    }
}
