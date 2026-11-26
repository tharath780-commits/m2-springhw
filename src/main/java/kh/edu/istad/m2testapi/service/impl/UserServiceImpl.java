package kh.edu.istad.m2testapi.service.impl;
import kh.edu.istad.m2testapi.dto.UserResponse;
import kh.edu.istad.m2testapi.mapper.UserMapper;
import kh.edu.istad.m2testapi.model.User;
import kh.edu.istad.m2testapi.repository.UserRepository;
import kh.edu.istad.m2testapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public Page<UserResponse> getAllWithPaging(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::mapUserToUserResponse);
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapUserToUserResponse)
                .toList();
    }


    @Override
    public UserResponse getByID(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::mapUserToUserResponse)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User not found"
                        ));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
