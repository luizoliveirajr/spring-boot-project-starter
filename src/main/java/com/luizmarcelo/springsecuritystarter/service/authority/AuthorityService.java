package com.luizmarcelo.springsecuritystarter.service.authority;

import com.luizmarcelo.springsecuritystarter.model.authority.Authority;
import com.luizmarcelo.springsecuritystarter.repository.authority.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }
    public Authority save(Authority authority) {
        return this.authorityRepository.save(authority);
    }
    public List<Authority> getAllAuthorities() {
        return this.authorityRepository.findAll();
    }
}
