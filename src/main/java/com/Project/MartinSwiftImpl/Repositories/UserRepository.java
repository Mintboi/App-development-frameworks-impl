package com.Project.MartinSwiftImpl.Repositories;

import com.Project.MartinSwiftImpl.Security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
