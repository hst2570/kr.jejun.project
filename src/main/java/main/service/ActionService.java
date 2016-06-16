package main.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by User on 2016-06-16.
 */
public interface ActionService {
    public String userAction(Long type, String user, Long comment, Model model);
}
