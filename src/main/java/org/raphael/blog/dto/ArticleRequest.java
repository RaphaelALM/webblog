package org.raphael.blog.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ArticleRequest(
        @NotBlank(message = "Title is required")
        String title,

        @NotNull(message = "publish date is required")
        LocalDateTime publishDateTime,

        @NotBlank(message = "Content is required")
        String content
) {
}
