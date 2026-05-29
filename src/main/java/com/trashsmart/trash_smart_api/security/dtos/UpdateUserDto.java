package com.trashsmart.trash_smart_api.security.dtos;

import lombok.Data;

@Data
public class UpdateUserDto {
    private String email;
    private String password;
}
