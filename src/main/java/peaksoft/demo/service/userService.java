package peaksoft.demo.service;

import peaksoft.demo.entity.User;

import java.util.List;

public interface userService {
    void saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void updateUser(Long id,User user);
    void deleteUser(Long id);
    User findByUserEmail(String email);
}
