package com.Project.JOB.Controller;

import com.Project.JOB.Model.Post;
import com.Project.JOB.Repository.PostRepository;
import com.Project.JOB.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Allow all origins for frontend access (adjust for prod)
@RestController
@RequestMapping("/posts") // Base path
public class PostController {

    @Autowired
    private PostRepository repo;

    @Autowired
    private SearchRepository srepo;

    // ✅ GET all job posts
    @GetMapping
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    // ✅ Add a new job post
    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return repo.save(post);
    }

    // ✅ Search posts by text
    @GetMapping("/search/{text}")
    public List<Post> search(@PathVariable String text) {
        return srepo.findByText(text);
    }

    // ✅ Simple hello test
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }

    // ✅ MongoDB connectivity test
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
}
