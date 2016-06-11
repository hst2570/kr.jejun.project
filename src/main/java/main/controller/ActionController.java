package main.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 2016-06-10.
 */
public class ActionController {
    /*
        추천 반대
     */
    @RequestMapping("/action")
    public String action(){
        return "action";
    }
}
