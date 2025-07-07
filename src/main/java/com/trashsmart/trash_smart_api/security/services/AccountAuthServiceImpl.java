package com.trashsmart.trash_smart_api.security.services;

import com.trashsmart.trash_smart_api.security.entities.AppRole;
import com.trashsmart.trash_smart_api.security.entities.AppUser;
import com.trashsmart.trash_smart_api.security.repository.AppRoleRepository;
import com.trashsmart.trash_smart_api.security.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class AccountAuthServiceImpl implements AccountAuthService {

    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;



    // Ajout d'un utilisateur avec mot de passe codé
    @Override
    public AppUser addUser(AppUser appUser) {
        // Cripter le password de l'utilisateur
        String hashedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(hashedPassword);
        return appUserRepository.save(appUser);
    }
    @Override
    public AppRole addRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }
    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.getRoles().add(appRole);
        appUserRepository.save(appUser);
    }
    /*@Override
    public void removeRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.getRoles().remove(appRole);
        appUserRepository.save(appUser);
    }*/
    @Override
    public AppUser getUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> appUsersList() {
        return appUserRepository.findAll();
    }


}
