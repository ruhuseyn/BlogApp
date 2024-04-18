package rufethuseynov.blogapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Data
@Builder
public class AdminBlogFilterResponse {

    String name;
    String title;
    String content;
    Long publishDate;
    Long viewCount;
    String coverImageUrl;
}
