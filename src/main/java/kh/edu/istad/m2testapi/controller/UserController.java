package kh.edu.istad.m2testapi.controller;

import kh.edu.istad.m2testapi.dto.UserResponse;
import kh.edu.istad.m2testapi.model.User;
//import kh.edu.istad.m2testapi.repository.UserRepository;
import kh.edu.istad.m2testapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Page<UserResponse> getAllWithPaging(
            @PageableDefault(
                    size = 5,
                    sort = "id",
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        return userService.getAllWithPaging(pageable);
    }
    @GetMapping("/{id}")
    public UserResponse getByID(@PathVariable UUID id){
        return userService.getByID(id);
    }
    // CREATE user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id) {

        userService.deleteUser(id);

        return "User deleted successfully";
    }
}
