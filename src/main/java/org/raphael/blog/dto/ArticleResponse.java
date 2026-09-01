package org.raphael.blog.dto;

import java.time.LocalDateTime;

public record ArticleResponse(
        Long id,
        String title,
        LocalDateTime publishDateTime,
        String content
) {
}
