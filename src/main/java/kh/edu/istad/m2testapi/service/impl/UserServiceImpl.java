package kh.edu.istad.m2testapi.service.impl;

import kh.edu.istad.m2testapi.model.User;
import kh.edu.istad.m2testapi.repository.UserRepository;
import kh.edu.istad.m2testapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.selectAll();
    }

    @Override
    public User getByID(UUID id) {
        return userRepository.selectById(id).orElseThrow();
    }

    @Override
    public User createUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
