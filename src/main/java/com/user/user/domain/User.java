package com.user.user.domain;

import com.user.user.adapter.web.model.UserRequestDto;
import com.user.user.adapter.web.model.UserResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "USERS", schema = "USR")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "REGISTRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime registrationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFICATION_DATE")
    private LocalDateTime modificationDate;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;

    public User(Long userId, String name, String email, String password, Long createdBy, Long modifiedBy) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public static User from(UserRequestDto userRequestDto){
      return User.builder()
              .userId(userRequestDto.getUserId())
              .name(userRequestDto.getName())
              .email(userRequestDto.getEmail())
              .password(userRequestDto.getPassword())
              .createdBy(userRequestDto.getCreatedBy())
              .modifiedBy(userRequestDto.getModifiedBy())
              .build();
    }

    //toUserResponseDto method
    public UserResponseDto toUserResponseDto() {
        return new UserResponseDto(userId, name, email, password, registrationDate, modificationDate, createdBy, modifiedBy);
    }

}