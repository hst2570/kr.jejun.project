package restAPI;

import domain.Action;
import domain.Comment;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.ActionRepository;
import repository.CommentRepository;
import repository.UserRepository;

import java.util.List;

/**
 * Created by user on 2016-06-10.
 */
@RestController
@RequestMapping("/rest")
public class RestAPI {
    /*
        * 가져와야할 데이터
        1. 회원정보
        2. 코멘트들
        3. 코멘트에 맞는 액션들
     */
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ActionRepository actionRepository;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable String id){
        return userRepository.findOne(id);
    }

    @RequestMapping("/comment/{id}")
    public Comment getComment(@PathVariable Long id){
        return commentRepository.findOne(id);
    }

    @RequestMapping("/comment")
    public List<Comment> getComment(){
        return commentRepository.findAll();
    }

    @RequestMapping("/action/{id}")
    public Action getAction(@PathVariable Long id){
        return actionRepository.findOne(id);
    }
}
