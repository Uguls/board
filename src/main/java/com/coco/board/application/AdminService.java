package com.coco.board.application;

import com.coco.board.application.dto.UserDto;
import com.coco.board.domain.User;
import com.coco.board.infrastructure.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}