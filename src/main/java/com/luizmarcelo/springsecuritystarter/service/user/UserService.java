package com.luizmarcelo.springsecuritystarter.service.user;

import com.luizmarcelo.springsecuritystarter.model.user.User;
import com.luizmarcelo.springsecuritystarter.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        try{
            return this.userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public Optional<User> findByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
