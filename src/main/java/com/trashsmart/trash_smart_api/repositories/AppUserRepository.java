package com.trashsmart.trash_smart_api.repositories;

import com.trashsmart.trash_smart_api.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
