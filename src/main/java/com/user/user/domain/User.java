package com.user.user.domain;

import com.user.user.adapter.web.model.UserResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "USERS", schema = "USR")
@NoArgsConstructor
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
    //toUserResponseDto method
    public UserResponseDto toUserResponseDto() {
        return new UserResponseDto(userId, name, email, password, registrationDate, modificationDate, createdBy, modifiedBy);
    }

    //of method
    public static User of(Long userId, String name, String email, String password, Long createdBy, Long modifiedBy) {
        return new User(userId, name, email, password, createdBy, modifiedBy);
    }



}