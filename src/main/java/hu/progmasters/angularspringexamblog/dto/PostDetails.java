package hu.progmasters.angularspringexamblog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.progmasters.angularspringexamblog.domain.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDetails {

    private Long id;
    private String imageUrl;
    private String title;
    private String text;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime createdAt;

    public PostDetails(Post post) {
        this.id = post.getId();
        this.imageUrl = post.getImageUrl();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
        this.text = post.getText();
    }
}
