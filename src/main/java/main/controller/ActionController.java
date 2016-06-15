package main.controller;

import main.domain.Action;
import main.domain.Comment;
import main.repository.ActionRepository;
import main.repository.CommentRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by User on 2016-06-15.
 */
@Controller
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping("/action/{type}/{user}/{comment}")
    public String index(@PathVariable Long type, @PathVariable String user, @PathVariable Long comment, Model model){
        if(user.equals("0")) return "redirect:/signup";

        List<Action> action = actionRepository.findAll();

        for(int i = 0; i < action.size(); i++){
            if(action.get(i).getUser().getUserId().equals(user) && action.get(i).getComment().equals(comment) &&
                    action.get(i).getType().equals(type)){ // 같은 글에 좋아요 또는 싫어요를 중복으로 누를 경우 취소된다.
                actionRepository.delete(action.get(i).getActionId());
                return "redirect:/";
            }else if(action.get(i).getUser().getUserId().equals(user) && action.get(i).getComment().equals(comment) &&
                    action.get(i).getType() != type){ // 같은 글에 좋아요 싫어요를 두번 누를경우
                model.addAttribute("actionCheck", "overlap");
                return "redirect:/";
            }
        }

        Action action1 = new Action();

        action1.setComment(commentRepository.findOne(comment).getCommentId());
        action1.setUser(userRepository.findOne(user));
        action1.setType(type);

        actionRepository.save(action1);

        return "redirect:/";
    }


}
