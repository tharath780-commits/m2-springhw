package kh.edu.istad.m2testapi.controller;

import kh.edu.istad.m2testapi.model.User;
import kh.edu.istad.m2testapi.repository.UserRepository;
import kh.edu.istad.m2testapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public User getByID(@PathVariable UUID id){
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
