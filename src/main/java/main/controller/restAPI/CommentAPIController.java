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


    @RequestMapping("/comment/{page}")
    public Comment[] getComments(@PathVariable int page) {
        Comment[] comment = new Comment[10];

        int temp = 0;

        for(int i = 0 ; i < page*10 ; i++){
            comment[i] = new Comment();
            System.out.println(comment[i].getCommentId());

            while (comment[i].getCommentId().equals(null)){
                comment[i] = commentRepository.findOne((long) temp);
                temp ++;
            }

            System.out.println(temp);
            System.out.println(i);
        }

        return comment;
    }

    @RequestMapping("/comment/add")
    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }
}
