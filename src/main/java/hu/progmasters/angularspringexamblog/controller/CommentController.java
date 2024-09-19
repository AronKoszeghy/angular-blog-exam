package hu.progmasters.angularspringexamblog.controller;

import hu.progmasters.angularspringexamblog.dto.CommentFormData;
import hu.progmasters.angularspringexamblog.dto.CommentListItem;
import hu.progmasters.angularspringexamblog.service.CommentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{id}/comments")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Void> addComment(@PathVariable Long id, @RequestBody @Valid CommentFormData commentFormData) {
        commentService.saveComment(commentFormData, id);
        logger.info("New comment is created");
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<CommentListItem>> getComments(@PathVariable Long id) {
        return ResponseEntity.ok(this.commentService.fetchCommentsByPost(id));
    }

}
