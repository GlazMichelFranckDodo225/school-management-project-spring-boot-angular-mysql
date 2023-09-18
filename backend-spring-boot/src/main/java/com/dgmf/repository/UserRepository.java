package com.dgmf.repository;

import com.dgmf.entity.User;
import com.dgmf.utils.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    User findByUserRole(UserRole role);
}