package com.Project.MartinSwiftImpl.Repositories;

import com.Project.MartinSwiftImpl.Security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
