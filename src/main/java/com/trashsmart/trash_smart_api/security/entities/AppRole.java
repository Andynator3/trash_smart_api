package com.trashsmart.trash_smart_api.security.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

   /* public AppRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }*/
}

