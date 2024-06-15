package com.user.user.service;

import com.user.user.adapter.persistence.UserRepository;
import com.user.user.adapter.web.model.UserRequestDto;
import com.user.user.adapter.web.model.UserResponseDto;
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
        return userRepository.save(userRequestDto.toEntity()).getUserId();
    }


    public UserResponseDto getUser(Long userId){
        return userRepository.findByUserId(userId).map(UserResponseDto::fromEntity).orElse(null);
    }

}
