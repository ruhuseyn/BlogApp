package rufethuseynov.blogapp.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import rufethuseynov.blogapp.dto.dto.WebBlogReadByIdDto;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
public class WebBlogReadByIdResponse {

    String name;
    String title;
    String content;
    Long publishDate;
    Long viewCount;
    String coverImageUrl;
    List<WebBlogReadByIdDto> webBlogReadByIdDtoList;

}
