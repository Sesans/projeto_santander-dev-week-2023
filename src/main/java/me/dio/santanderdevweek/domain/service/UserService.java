package me.dio.santanderdevweek.domain.service;

import me.dio.santanderdevweek.domain.models.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
