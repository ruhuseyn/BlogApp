package rufethuseynov.blogapp.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rufethuseynov.blogapp.dto.request.UserUpdateRequestDto;
import rufethuseynov.blogapp.service.admin.UserService;
import rufethuseynov.blogapp.dto.request.RegisterRequest;

@RestController
@RequestMapping("/api/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterRequest request) {
        userService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody @Valid RegisterRequest request) {
        return userService.login(request);
    }

    @PostMapping("/update-profile")
    @ResponseStatus(HttpStatus.OK)
    public void updateProfile(@RequestBody UserUpdateRequestDto dto){
        userService.updateProfile(dto);
    }

}
