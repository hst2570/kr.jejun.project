package main.controller;

import main.domain.Comment;
import main.repository.CommentRepository;
import main.repository.UserRepository;
import main.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * Created by user on 2016-06-10.
 */
@Controller
public class CommentController {
    /*
        1. 로그인창
        2. 글 작성
     */
    @Autowired
    private CommentService commentService;

    @RequestMapping("/")
    public String index(HttpSession session){
        return "index";
    }

    @RequestMapping("/comment")
    public String checkUser(HttpSession session){
        if (session.getId() == null){
            return "singup";
        }
        return "comment";
    }

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public String addComment(HttpServletRequest request, HttpSession session){
        commentService.addComment(request);

        return "redirect:/";
    }

    @RequestMapping(value = "/comment/delete/{id}")
    public String deleteComment(@PathVariable Long id, HttpSession session){
        commentService.deleteComment(id);

        return "redirect:/";
    }


}
