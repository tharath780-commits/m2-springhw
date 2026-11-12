package kh.edu.istad.m2testapi.service;

import kh.edu.istad.m2testapi.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    //your logic

    List<User> getAllUser();
    User getByID(UUID id);
    User createUser(User user);
    void deleteUser(UUID id);
}
