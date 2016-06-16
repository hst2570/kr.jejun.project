package main.service;

import main.domain.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 2016-06-16.
 */
@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void updateUser(String id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("userName", user.getName());
        model.addAttribute("userDes", user.getDes());
        model.addAttribute("userImage", user.getImage());
    }

    @Override
    public String signin(HttpSession session, HttpServletRequest request) {
        List<User> user =  userRepository.findAll();

        for(int i = 0; i < user.size(); i++){
            if(user.get(i).getUserId().equals(request.getParameter("userId"))
                    && user.get(i).getPassword().equals(request.getParameter("password"))){

                session.setAttribute("getId", request.getParameter("userId"));
                session.setAttribute("login", "ok");
                return "redirect:/";
            }
        }

        session.setAttribute("login", "fail");
        return "signin";
    }

    @Override
    public void addUser(HttpServletRequest request, MultipartFile image) throws IOException {
        User user = new User();
        user.setUserId(request.getParameter("userId"));
        user.setDes(request.getParameter("des"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));

        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/resources/static/image/" + image.getOriginalFilename()));
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        outputStream.write(image.getBytes());
        outputStream.close();

        user.setImage("static/image/" + image.getOriginalFilename());

        userRepository.save(user);
    }
}
