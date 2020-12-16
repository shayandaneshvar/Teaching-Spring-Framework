package com.mapsa.dockerjavademo.controller;

import com.mapsa.dockerjavademo.model.Comment;
import com.mapsa.dockerjavademo.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final CommentRepository commentRepository;

    @GetMapping
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye";
    }

    @PostMapping("/comment")
    public Comment comment(@RequestParam String comment) {
        return commentRepository.save(new Comment().setContent(comment));
    }

    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentRepository.findById(id).orElseThrow();
    }

    @GetMapping("/comment/all")
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
}
