package rufethuseynov.blogapp.service.admin;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.request.RegisterRequest;
import rufethuseynov.blogapp.entity.User;
import rufethuseynov.blogapp.mapper.UserMapper;
import rufethuseynov.blogapp.repository.UserRepository;
import rufethuseynov.blogapp.security.JwtService;
import rufethuseynov.blogapp.exception.subexceptions.UserNotFoundException;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserService{

    UserRepository userRepository;
    UserMapper mapper;
    PasswordEncoder encoder;
    JwtService jwtService;
    AuthenticationManager authenticationManager;

    public User getUserByEmail(String email) {
        return userRepository
                .findUserByEmail(email)
                .orElseThrow(()->new UserNotFoundException("User tapilmadi"));
    }

    public void register(RegisterRequest request) {
        User user = mapper.toUserFromRegisterRequest(request);
        user.setPassword(encoder.encode(request.getPassword()));
        userRepository.save(user);
    }

    public String login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserDetails user = mapper.toMyUserDetails(getUserByEmail(request.getEmail()));

        return jwtService.generateToken(user);
    }

}
