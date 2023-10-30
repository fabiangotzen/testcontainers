package com.fago.testcontainers;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    void save(UserDto userDto) {
        this.userRepository.save(new User(userDto.id(), userDto.name(), userDto.age()));
    }

}
