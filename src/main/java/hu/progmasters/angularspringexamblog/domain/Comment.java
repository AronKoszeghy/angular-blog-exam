package hu.progmasters.angularspringexamblog.domain;

import hu.progmasters.angularspringexamblog.dto.CommentFormData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String text;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(CommentFormData commentFormData) {
        this.author = commentFormData.getAuthor();
        this.text = commentFormData.getText();
        this.createdAt = LocalDateTime.now();
    }
}
