package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return repository.findById(id);
    }
    public User createUser(User user) {
        // ensure MongoDB auto-generates ID
        user.setId(null);

        // set default role
        if (user.getRole() == null || user.getRole().trim().isEmpty()) {
            user.setRole("USER");
        } else {
            user.setRole(user.getRole().trim().toUpperCase());
        }

        return repository.save(user);
    }



    public User updateUser(String id, User updatedUser) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    user.setAge(updatedUser.getAge());
                    user.setRole(updatedUser.getRole());
                    user.setRole(updatedUser.getRole());
                    user.setPhone(updatedUser.getPhone());
                    return repository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
