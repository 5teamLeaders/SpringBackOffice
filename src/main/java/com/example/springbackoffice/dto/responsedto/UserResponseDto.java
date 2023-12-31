package com.example.springbackoffice.dto.responsedto;

import com.example.springbackoffice.entity.User;
import com.example.springbackoffice.entity.UserRoleEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
// 특정 유저의 정보 조희
public class UserResponseDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String intro;
    private UserRoleEnum role;
    private Integer followerCount;
    private Integer followingCount;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password=user.getPassword();
        this.email=user.getEmail();
        this.intro = user.getSelfIntroduction();
        this.role=user.getRole();
        this.followerCount = user.getFollowerCount();
        this.followingCount = user.getFollowingCount();
    }
}