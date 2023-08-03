package com.example.springbackoffice.dto.responsedto;

import com.example.springbackoffice.entity.Comment;
import com.example.springbackoffice.entity.Post;
import com.example.springbackoffice.entity.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class ProfileResponseDto {

    private String username;
    private String selfIntroduction;
    private List<PostResponseDto> postList;
    private List<CommentResponseDto> commentList;


    public ProfileResponseDto(User user, List<Post> postList, List<Comment> commentList) {
        this.username = user.getUsername();
        this.selfIntroduction = user.getSelfIntroduction();
        this.postList = postList.stream().map(PostResponseDto::new).collect(Collectors.toList());
        this.commentList = commentList.stream().map(CommentResponseDto::new).collect(Collectors.toList());
//        this.commentList = user.getCommentList().stream()
//                .map(CommentResponseDto::new)
//                .collect(Collectors.toList());
    }
}
