package com.example.SpringSecurityRestAPI.repository;

import com.example.SpringSecurityRestAPI.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
