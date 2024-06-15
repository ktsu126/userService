package com.user.user.adapter.web.in;


import com.user.user.adapter.web.model.UserRequestDto;
import com.user.user.adapter.web.model.UserResponseDto;
import com.user.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String init(){
        return userService.init();
    }

    @PostMapping("/user/create")
    public Long createUser(@RequestBody @Valid UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }

    @PostMapping("/user/update")
    public Long updateUser(@RequestBody @Valid UserRequestDto userRequestDto){
        return userService.updateUser(userRequestDto);
    }

    @GetMapping("/users/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) throws Exception{
        return userService.getUser(userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) throws Exception{
        userService.deleteUser(userId);
    }

}
