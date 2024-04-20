package rufethuseynov.blogapp.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
public class WebContactUserReadAllResponse {

    String name;
    String phoneNumber;
    String email;
    String message;
}
