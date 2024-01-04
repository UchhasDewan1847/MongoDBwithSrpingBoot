package com.agent47.mongodbSpringBoot.Controller;

import com.agent47.mongodbSpringBoot.model.Post;
import com.agent47.mongodbSpringBoot.repository.PostRepository;
import com.agent47.mongodbSpringBoot.repository.SearchRepository;
import com.agent47.mongodbSpringBoot.repository.SearchRepositoryImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
public class JobController {
//    @ApiIgnore
//    @RequestMapping("/")
//    public void redirect(HttpServletResponse servletResponse) throws IOException {
//        servletResponse. sendRedirect("/swagger-ui.html");
//    }
    @Autowired
    private PostRepository repository;
    @Autowired
    private SearchRepository searchRepository;

    @PostMapping("/add/post")
    public Post addPost(@RequestBody Post post){
        return repository.save(post);
    }
    @GetMapping("/now/posts/{value}")
    public List<Post> filteredPosts(@PathVariable String value){
        return searchRepository.findByText(value);
    }
    @GetMapping("/posts")
    public List<Post> getPosts(){
        return repository.findAll();
    }
}
