package com.trashsmart.trash_smart_api.services;

import com.trashsmart.trash_smart_api.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountService accountService;

    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = accountService.getUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}

