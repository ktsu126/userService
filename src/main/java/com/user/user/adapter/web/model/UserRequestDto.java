package com.user.user.adapter.web.model;

import com.user.user.domain.User;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
@Getter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UserRequestDto implements Serializable {
    Long userId;
    String name;
    String email;
    String password;
    Long createdBy;
    Long modifiedBy;

    public User toEntity() {
        return new User(userId, name, email, password, createdBy, modifiedBy);
    };

}