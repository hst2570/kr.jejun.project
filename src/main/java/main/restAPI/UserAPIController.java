package main.restAPI;

import main.domain.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/user/add")
    public User addUser(User user){
        return userRepository.save(user);
    }

}
