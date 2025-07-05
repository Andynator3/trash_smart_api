package com.trashsmart.trash_smart_api.security.repository;

import com.trashsmart.trash_smart_api.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.Optional;


/**
 *
 * */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
   AppUser findByUsername(String username);
}
