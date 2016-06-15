package main.controller.restAPI;

import main.domain.Comment;
import main.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by User on 2016-06-11.
 */
@RestController
@RequestMapping("/rest")
public class CommentAPIController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping("/comment/{id}")
    public Comment getComment(@PathVariable Long id){
        return commentRepository.findOne(id);
    }

    @RequestMapping("/comment")
    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    @RequestMapping("/comment/add")
    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }
}
