package rufethuseynov.blogapp.dto.dto;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
public class ImageSaveDto {
    String imageUrl;
    String subTitle;
}
