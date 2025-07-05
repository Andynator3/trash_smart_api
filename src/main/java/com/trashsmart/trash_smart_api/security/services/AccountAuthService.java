package com.trashsmart.trash_smart_api.security.services;

import com.trashsmart.trash_smart_api.security.entities.AppRole;
import com.trashsmart.trash_smart_api.security.entities.AppUser;

import java.util.List;

public interface AccountAuthService {
    AppUser getUserByUsername(String username);
    AppUser addUser(AppUser appUser);
    AppRole addRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    List<AppUser> appUsersList();
}

