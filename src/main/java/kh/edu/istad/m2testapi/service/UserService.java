package kh.edu.istad.m2testapi.service;

import kh.edu.istad.m2testapi.dto.UserResponse;
import kh.edu.istad.m2testapi.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.UUID;

public interface UserService {

    //your logic
    Page<UserResponse> getAllWithPaging(Pageable pageable);

    List <UserResponse> getAllUser();
    UserResponse getByID(UUID id);
    User createUser(User user);
    void deleteUser(UUID id);

}
