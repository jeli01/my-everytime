package com.jeli.myeverytime.controller.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
    @GetMapping
    public String post() {
        return "post/post";
    }

    @GetMapping("/free")
    public String post2() {
        return "post/posts";
    }

    @GetMapping("/article")
    public String post3() {
        return "post/article";
    }

    @GetMapping("/create")
    public String post4() {
        return "post/create-article";
    }
}
