package com.jeli.myeverytime.controller;

import com.jeli.myeverytime.domain.Member;
import com.jeli.myeverytime.domain.Post;
import com.jeli.myeverytime.dto.CreatePostForm;
import com.jeli.myeverytime.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.jeli.myeverytime.login.SessionConst.LOGIN_MEMBER;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @GetMapping
    public String post(
            @RequestParam(required = false, defaultValue = "") String type,
            @RequestParam(required = false, defaultValue = "") Long postId,
            Model model
    ) {
        if (postId == null) {
            System.out.println("type= " + type);
            System.out.println("id = " + postId);
            List<Post> posts = postRepository.findPostByType(type);
            model.addAttribute("posts", posts);
            return "post/post";
        }
        else {
            Post post = postRepository.findOne(postId);
            model.addAttribute("post", post);
            return "post/article";
        }

    }

    @GetMapping("/create")
    public String createform(Model model) {
        CreatePostForm createPostForm = new CreatePostForm();
        model.addAttribute("createPostForm", createPostForm);
        return "post/create-article";
    }

    @PostMapping
    public String create(
            @ModelAttribute CreatePostForm createPostForm,
            @SessionAttribute(name = LOGIN_MEMBER, required = false) Member loginMember
    ) {
        Post post = new Post();
        post.setType(createPostForm.getType());
        post.setTitle(createPostForm.getTitle());
        post.setContents(createPostForm.getContents());
        post.setWriter(loginMember);
        post.setCreateDate(LocalDateTime.now());
        post.setUpdateDate(LocalDateTime.now());
        postRepository.save(post);
        return "redirect:/post?type=" + post.getType();
    }
}
