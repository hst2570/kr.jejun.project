package main.restAPI;

import main.domain.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request){
        User user = new User();
        user.setUserId(request.getParameter("userId"));
        user.setDes(request.getParameter("des"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));

        user.setImage(request.getParameter("image"));
        userRepository.save(user);
        return "index";
    }

}
