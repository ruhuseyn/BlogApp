package rufethuseynov.blogapp.dto.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
public class BlogPageDto {

    String coverImageUrl;
    String name;
    Long publishDate;
}
