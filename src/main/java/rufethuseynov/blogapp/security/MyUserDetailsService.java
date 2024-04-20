package rufethuseynov.blogapp.security;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.repository.UserRepository;
import rufethuseynov.blogapp.mapper.UserMapper;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.toMyUserDetails(userRepository.findUserByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("User is not found")));
    }
}
