// CustomUserDetailsService.java
package com.Project.MartinSwiftImpl.Services;

import  com.Project.MartinSwiftImpl.Security.User;
import  com.Project.MartinSwiftImpl.Repositories.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findById(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found")
        );

        // Convert user roles to GrantedAuthorities
        // Implement this according to your needs

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true, true, true,
                user.getAuthorities()
        );
    }
}
