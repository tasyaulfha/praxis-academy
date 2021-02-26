package com.example.jwauth.repository;

import com.example.jwauth.model.Role;
import com.example.jwauth.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository <Role,Long>{
    Optional<Role> findByName(RoleName roleName);
}
