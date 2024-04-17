package rufethuseynov.blogapp.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import rufethuseynov.blogapp.dto.dto.BlogPageDto;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
public class BlogPageResponse {

    List<BlogPageDto> users;
    long totalElements;
    int totalPages;
    boolean hasNextPage;
}
