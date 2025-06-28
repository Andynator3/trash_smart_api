package com.trashsmart.trash_smart_api.repositories;

import com.trashsmart.trash_smart_api.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
