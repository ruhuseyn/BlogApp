package rufethuseynov.blogapp.dto.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
public class BlogSaveDto {

    String name;
    String title;
    String content;
    Long publishDate;
}
