package com.trashsmart.trash_smart_api.security.repository;

import com.trashsmart.trash_smart_api.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
