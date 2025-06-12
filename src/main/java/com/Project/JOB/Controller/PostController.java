package com.Project.JOB.Controller;

import com.Project.JOB.Model.Post;
import com.Project.JOB.Repository.PostRepository;
import com.Project.JOB.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {

    @Autowired  //Means Spring Will Create object for you//
    PostRepository repo;
    @Autowired
    SearchRepository srepo;


    @GetMapping("/posts")
    public List<Post> getAllPosts(){

        return repo.findAll();
    }
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
       return repo.save(post);
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
    @GetMapping("/test-mongo")
    public String testMongo() {
        try {
            List<Post> posts = repo.findAll();
            return "Fetched " + posts.size() + " posts from MongoDB";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

}
