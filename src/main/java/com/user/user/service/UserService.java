package com.user.user.service;

import com.user.user.adapter.persistence.UserRepository;
import com.user.user.adapter.web.model.UserRequestDto;
import com.user.user.adapter.web.model.UserResponseDto;
import com.user.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public String init(){
        return "Hello world!!";
    }

    public Long createUser(UserRequestDto userRequestDto){
        return userRepository.save(User.from(userRequestDto)).getUserId();
    }

    public Long updateUser(UserRequestDto userRequestDto) {
        return userRepository.save(User.from(userRequestDto)).getUserId();
    }

    public UserResponseDto getUser(Long userId){
        return userRepository.findByUserId(userId)
                .map(UserResponseDto::from)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long userId) {
        userRepository.deleteByUserId(userId);
    }
}
