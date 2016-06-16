package main.controller.restAPI;

import main.domain.Comment;
import main.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by User on 2016-06-11.
 */
@RestController
@RequestMapping("/rest")
public class CommentAPIController {

    @Autowired
    private CommentRepository commentRepository;


    @RequestMapping("/comment/{page}")
    public Page<Comment> getComments(@PathVariable int page)  {
        String properties = "commentId";
        Pageable pageable = new PageRequest(page,5, Sort.Direction.DESC, properties);

        Page<Comment> comment = commentRepository.findAll(pageable);

        return comment;
    }
}
