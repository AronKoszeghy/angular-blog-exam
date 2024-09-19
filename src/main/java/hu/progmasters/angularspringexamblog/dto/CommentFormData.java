package hu.progmasters.angularspringexamblog.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentFormData {

    private String author;

    @NotEmpty
    private String text;

}
