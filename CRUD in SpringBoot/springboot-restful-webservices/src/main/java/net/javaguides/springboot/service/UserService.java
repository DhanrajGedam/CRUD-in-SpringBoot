package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User upDatedUser(User user);
    void DeleteUser(Long userId);
    void deleteAllUsers();
}
