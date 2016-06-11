package main.restAPI;

import main.domain.Action;
import main.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by User on 2016-06-11.
 */
@RestController
@RequestMapping("/rest")
public class ActionAPIController {
    @Autowired
    private ActionRepository actionRepository;

    @RequestMapping("/action/{id}")
    public Action getAction(@PathVariable Long id){
        return actionRepository.findOne(id);
    }
}
