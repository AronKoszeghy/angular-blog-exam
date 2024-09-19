package hu.progmasters.angularspringexamblog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.progmasters.angularspringexamblog.domain.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostListItem {

    private Long id;
    private String imageUrl;
    private String title;
    private String body;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime createdAt;

    public PostListItem(Post post) {
        this.id = post.getId();
        this.imageUrl = post.getImageUrl();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();

        String text = post.getText();
        this.body = text.length() > 200
                ? text.substring(0, 200)
                : text;
    }
}
