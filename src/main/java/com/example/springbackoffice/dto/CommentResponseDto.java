package com.example.springbackoffice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponseDto extends ApiResponseDto{


    private String contents; // 본문
    private String username;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private Long post_id;

    public CommentResponseDto(Comment comment) {

        super();
        this.post_id = comment.getId();
        this.contents = comment.getContents();
        this.username = comment.getUser().getUsername();
        this.created_at =comment.getPost().getCreatedAt();
        this.modified_at = comment.getPost().getModifiedAt();
    }
}
