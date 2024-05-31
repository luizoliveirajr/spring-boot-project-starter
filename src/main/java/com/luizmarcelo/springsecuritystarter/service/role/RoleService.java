package com.luizmarcelo.springsecuritystarter.service.role;

import com.luizmarcelo.springsecuritystarter.model.role.Role;
import com.luizmarcelo.springsecuritystarter.repository.role.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role save(Role role) {
        return this.roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }
}
