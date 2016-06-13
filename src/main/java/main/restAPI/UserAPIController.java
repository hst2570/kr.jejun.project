package main.restAPI;

import main.domain.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by User on 2016-06-11.
 */
@RestController
@RequestMapping("/rest")
public class UserAPIController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable String id){
        return userRepository.findOne(id);
    }

}
