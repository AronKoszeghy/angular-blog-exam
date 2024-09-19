package hu.progmasters.angularspringexamblog.service;

import hu.progmasters.angularspringexamblog.domain.Comment;
import hu.progmasters.angularspringexamblog.domain.Post;
import hu.progmasters.angularspringexamblog.dto.CommentFormData;
import hu.progmasters.angularspringexamblog.dto.CommentListItem;
import hu.progmasters.angularspringexamblog.repo.CommentRepo;
import hu.progmasters.angularspringexamblog.repo.PostRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepo commentRepo;
    private PostRepo postRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo , PostRepo postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    public void saveComment(CommentFormData commentFormData, Long postId) {
        Comment comment = new Comment(commentFormData);
        comment.setPost(this.postRepo.findById(postId).get());
        this.commentRepo.save(comment);
    }

    public List<CommentListItem> fetchCommentsByPost(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow();
        List<Comment> comments = commentRepo.findCommentsByPostOrderByCreatedAtDesc(post);
        return comments.stream().map(comment -> new CommentListItem(comment)).toList();
    }
}
