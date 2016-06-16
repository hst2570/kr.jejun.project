package main.service;

import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 2016-06-16.
 */
public interface CommentService {
    public void addComment(HttpServletRequest request);
    public void deleteComment(Long id);
}
