package peaksoft.demo.service.impl;

import peaksoft.demo.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.demo.repository.userRepo;
import peaksoft.demo.service.userService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor

public class userServiceImpl implements userService {
    private final userRepo userRepo;
    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void updateUser(Long id, User user) {
        User user1 = userRepo.findById(id).get();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setAge(user.getAge());
        userRepo.save(user);

    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);

    }

    @Override
    public User findByUserEmail(String email) {
        return userRepo.findUserByEmail(email);
    }
}
