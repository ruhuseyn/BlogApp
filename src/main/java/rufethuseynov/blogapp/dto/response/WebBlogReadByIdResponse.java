package rufethuseynov.blogapp.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import rufethuseynov.blogapp.dto.dto.WebBlogReadDto;
import rufethuseynov.blogapp.dto.dto.WebBlogReadImageDto;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
public class WebBlogReadByIdResponse {

    WebBlogReadDto webBlogReadDto;
    List<WebBlogReadImageDto> webBlogReadByIdDtoList;

}
