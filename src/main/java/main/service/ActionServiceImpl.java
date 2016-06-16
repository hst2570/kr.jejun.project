package main.service;

import main.domain.Action;
import main.repository.ActionRepository;
import main.repository.CommentRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by User on 2016-06-16.
 */
@Service("ActionService")
public class ActionServiceImpl implements ActionService {
    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public String userAction(Long type, String user, Long comment, Model model) {
        if(user.equals("0")) return "redirect:/signup";

        List<Action> action = actionRepository.findAll();

        for(int i = 0; i < action.size(); i++){
            if(action.get(i).getUserId().equals(user) && action.get(i).getCommentId().equals(comment) &&
                    action.get(i).getType().equals(type)){ // 같은 글에 좋아요 또는 싫어요를 중복으로 누를 경우 취소된다.
                actionRepository.delete(action.get(i).getActionId());
                return "redirect:/";
            }else if(action.get(i).getUserId().equals(user) && action.get(i).getCommentId().equals(comment) &&
                    action.get(i).getType() != type){ // 같은 글에 좋아요 싫어요를 두번 누를경우
                model.addAttribute("actionCheck", "overlap");
                return "redirect:/";
            }
        }

        Action action1 = new Action();

        action1.setCommentId(commentRepository.findOne(comment).getCommentId());
        action1.setUserId(userRepository.findOne(user).getUserId());
        action1.setType(type);

        actionRepository.save(action1);

        return "redirect:/";
    }
}
