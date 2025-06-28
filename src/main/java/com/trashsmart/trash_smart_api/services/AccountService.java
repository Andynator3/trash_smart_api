package com.trashsmart.trash_smart_api.services;

import com.trashsmart.trash_smart_api.entities.AppRole;
import com.trashsmart.trash_smart_api.entities.AppUser;

public interface AccountService {
    AppUser addUser(AppUser user);
    AppRole addRole(AppRole role);
    void addRoleToUser(String username, String roleName);
    AppUser getUserByUsername(String username);
}

