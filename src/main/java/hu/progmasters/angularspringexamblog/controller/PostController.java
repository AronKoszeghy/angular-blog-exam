package hu.progmasters.angularspringexamblog.controller;

import hu.progmasters.angularspringexamblog.dto.CommentFormData;
import hu.progmasters.angularspringexamblog.dto.PostDetails;
import hu.progmasters.angularspringexamblog.dto.PostFormData;
import hu.progmasters.angularspringexamblog.dto.PostListItem;
import hu.progmasters.angularspringexamblog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hu.progmasters.angularspringexamblog.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody @Valid PostFormData postFormData) {
        this.postService.savePost(postFormData);
        logger.info("New post is created");
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<PostListItem>> getPosts() {
        logger.info("Post list page is requested");
        return ResponseEntity.ok(postService.fetchPosts());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<PostDetails> getPost(@PathVariable Long id) {
        PostDetails postDetails = postService.fetchPostById(id);
        return ResponseEntity.ok(postDetails);
    }


}
