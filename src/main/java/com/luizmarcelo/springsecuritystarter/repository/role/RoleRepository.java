package com.luizmarcelo.springsecuritystarter.repository.role;

import com.luizmarcelo.springsecuritystarter.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}