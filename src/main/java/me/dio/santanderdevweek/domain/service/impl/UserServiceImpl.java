package me.dio.santanderdevweek.domain.service.impl;

import me.dio.santanderdevweek.domain.models.User;
import me.dio.santanderdevweek.domain.repository.UserRepository;
import me.dio.santanderdevweek.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("Já existe um usuário cadastrado com este ID");
        }
        return userRepository.save(userToCreate);
    }
}
