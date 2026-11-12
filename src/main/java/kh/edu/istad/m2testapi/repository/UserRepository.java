package kh.edu.istad.m2testapi.repository;

import kh.edu.istad.m2testapi.model.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        User usrAdmin = new User(UUID.randomUUID(), "Administrator", "admin", "qwer", true);
        User usrEditor = new User(UUID.randomUUID(), "Editor", "editor", "qwer", false);
        User usrCustomer = new User(UUID.randomUUID(), "Chan Dara", "chandara", "qwer", true);
        User usrEmployee = new User(UUID.randomUUID(), "Tharath", "rothroth", "thrr", true);
        users.add(usrAdmin);
        users.add(usrEditor);
        users.add(usrCustomer);
        users.add(usrEmployee);
    }

    public List<User> selectAll() {
        return users;
    }

    public Optional<User> selectById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public User insert(User user) {
        users.add(user);
        return user;
    }
    public boolean deleteById(UUID id) {
        return users.removeIf(
                user -> user.getId().equals(id));
    }

}