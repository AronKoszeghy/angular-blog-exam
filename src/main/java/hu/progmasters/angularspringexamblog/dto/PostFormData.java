package hu.progmasters.angularspringexamblog.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostFormData {

    @NotEmpty
    private String title;

    @NotEmpty
    private String text;

    private String imageUrl;

}
