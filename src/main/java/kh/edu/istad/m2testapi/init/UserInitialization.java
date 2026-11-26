package kh.edu.istad.m2testapi.init;

import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;
import kh.edu.istad.m2testapi.model.User;
import kh.edu.istad.m2testapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class UserInitialization {
    private final UserRepository userRepository;

    public UserInitialization(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    void init(){
        log.info("initializing user data");
        //1 create entity object
        User user1 = new User();
        user1.setName("Administrator");
        user1.setUsername("admin");
        user1.setPassword("8848");
        user1.setIsActive(true);

        //2 Start saving user into database table
        if (userRepository.count() == 0
        ) {
            userRepository.save(user1);
        }
        User user2 = new User();
        user2.setName("Tharath");
        user2.setUsername("roth");
        user2.setPassword("888");
        user2.setIsActive(true);
    }
}
