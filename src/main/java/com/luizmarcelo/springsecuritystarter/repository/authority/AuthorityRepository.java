package com.luizmarcelo.springsecuritystarter.repository.authority;

import com.luizmarcelo.springsecuritystarter.model.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}