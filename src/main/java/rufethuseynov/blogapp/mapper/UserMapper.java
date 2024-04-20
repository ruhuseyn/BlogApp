package rufethuseynov.blogapp.mapper;

import org.mapstruct.Mapper;
import rufethuseynov.blogapp.dto.request.RegisterRequest;
import rufethuseynov.blogapp.entity.User;
import rufethuseynov.blogapp.security.MyUserDetails;

@Mapper(componentModel = "spring")
public interface UserMapper {

    MyUserDetails toMyUserDetails(User user);

    User toUserFromRegisterRequest(RegisterRequest request);

}
