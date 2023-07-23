package com.example.springbackoffice.dto;

import com.example.springbackoffice.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponseDto extends ApiResponseDto{

    private Long id;
    private String contents; // 본문
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Integer commentLikeCount;
    public CommentResponseDto(Comment comment) {

        this.id = comment.getId();
        this.contents = comment.getContents();
        this.userName = comment.getUser().getUsername();
        this.createdAt =comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.commentLikeCount = comment.getCommentLikedCount();
    }
}
