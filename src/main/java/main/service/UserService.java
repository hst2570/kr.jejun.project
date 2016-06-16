package main.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 2016-06-16.
 */
public interface UserService {
    public void  updateUser(String id, Model model);
    public String signin(HttpSession session, HttpServletRequest request);
    public void addUser(HttpServletRequest request, MultipartFile image) throws IOException;
}
