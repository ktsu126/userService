package com.user.user.adapter.web.model;

import com.user.user.domain.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Getter
@NoArgsConstructor
public class UserRequestDto implements Serializable {
    @NotNull
    Long userId;

    String name;

    String email;

    String password;

    Long createdBy;

    Long modifiedBy;

}