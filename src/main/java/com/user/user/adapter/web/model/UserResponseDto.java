package com.user.user.adapter.web.model;

import com.user.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link User}
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto implements Serializable {
    Long userId;
    String name;
    String email;
    String password;
    LocalDateTime registrationDate;
    LocalDateTime modificationDate;
    Long createdBy;
    Long modifiedBy;


    public static UserResponseDto from(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRegistrationDate(),
                user.getModificationDate(),
                user.getCreatedBy(),
                user.getModifiedBy()
        );
    }
}
