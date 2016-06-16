package main.service;

import main.domain.Comment;
import main.repository.CommentRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 2016-06-16.
 */
@Service("CommentService")
public class CommentServiceImpl implements CommentService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private main.repository.CommentRepository CommentRepository;

    public void addComment(HttpServletRequest request){
        Comment comment = new Comment();
        long time = System.currentTimeMillis();

        comment.setContent(request.getParameter("content"));
        comment.setDate(Long.toString(time));
        comment.setUser(userRepository.findOne(request.getParameter("userId")));

        CommentRepository.save(comment);
    }

    @Override
    public void deleteComment(@PathVariable Long id) {
        CommentRepository.delete(id);
    }

}
