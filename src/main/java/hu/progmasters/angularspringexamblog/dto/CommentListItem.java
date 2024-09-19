package hu.progmasters.angularspringexamblog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.progmasters.angularspringexamblog.domain.Comment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentListItem {

    private String author;
    private String text;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime createdAt;

    public CommentListItem(Comment comment) {
        this.author = comment.getAuthor();
        this.text = comment.getText();
        this.createdAt = comment.getCreatedAt();
    }
}
