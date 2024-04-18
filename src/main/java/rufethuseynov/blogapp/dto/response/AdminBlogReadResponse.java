package rufethuseynov.blogapp.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import rufethuseynov.blogapp.dto.dto.AdminBlogReadDto;
import rufethuseynov.blogapp.dto.dto.AdminImageReadDto;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
public class AdminBlogReadResponse {

    AdminBlogReadDto adminBlogReadDto;
    List<AdminImageReadDto> adminImageReadDtoList;
}
