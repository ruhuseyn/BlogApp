package rufethuseynov.blogapp.utility;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Component
public class SessionManager {


    String userId;
    String currentUserId;
    String currentUserName;
    String currentThreadId;
    String currentRoleId;
    String userType;
    String domain;
    String token;


}
