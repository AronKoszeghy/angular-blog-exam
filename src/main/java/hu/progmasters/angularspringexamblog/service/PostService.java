package hu.progmasters.angularspringexamblog.service;

import hu.progmasters.angularspringexamblog.domain.Post;
import hu.progmasters.angularspringexamblog.dto.PostDetails;
import hu.progmasters.angularspringexamblog.dto.PostFormData;
import hu.progmasters.angularspringexamblog.dto.PostListItem;
import hu.progmasters.angularspringexamblog.repo.PostRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public void savePost(@Valid PostFormData postFormData) {
        this.postRepo.save(new Post(postFormData));
    }

    public List<PostListItem> fetchPosts() {
        List<Post> posts = this.postRepo.findAllByOrderByCreatedAtDesc();
        return posts.stream().map(PostListItem::new).toList();
    }

    public PostDetails fetchPostById(Long id) {
        Post post = this.postRepo.findById(id).orElse(null);
        return new PostDetails(post);
    }
}
