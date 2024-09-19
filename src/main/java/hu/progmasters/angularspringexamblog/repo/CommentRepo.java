package hu.progmasters.angularspringexamblog.repo;

import hu.progmasters.angularspringexamblog.domain.Comment;
import hu.progmasters.angularspringexamblog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByPostOrderByCreatedAtDesc(Post post);
}
