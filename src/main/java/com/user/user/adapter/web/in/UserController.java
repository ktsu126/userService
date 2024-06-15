package com.user.user.adapter.web.in;


import com.user.user.adapter.web.model.UserRequestDto;
import com.user.user.adapter.web.model.UserResponseDto;
import com.user.user.service.UserService;
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

    @PostMapping("/user")
    public Long createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }

    @PostMapping("/user/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }


}
