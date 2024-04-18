package rufethuseynov.blogapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import rufethuseynov.blogapp.dto.dto.BlogSaveDto;
import rufethuseynov.blogapp.dto.dto.ImageSaveDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Data
@Builder
public class BlogSaveRequestDto {

    BlogSaveDto blogSaveDto;
    List<ImageSaveDto> imageSaveDtoList;
}
