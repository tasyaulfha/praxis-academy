package com.example.bankmanagement.repository;

import com.example.bankmanagement.security.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Object findByName(String role_user);
}
