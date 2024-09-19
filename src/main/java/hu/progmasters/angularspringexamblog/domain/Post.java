package hu.progmasters.angularspringexamblog.domain;

import hu.progmasters.angularspringexamblog.dto.PostFormData;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private String imageUrl;
    private LocalDateTime createdAt;

    public Post(PostFormData postFormData) {
        this.title = postFormData.getTitle();
        this.text = postFormData.getText();
        this.imageUrl = postFormData.getImageUrl();
        this.createdAt = LocalDateTime.now();
    }
}
