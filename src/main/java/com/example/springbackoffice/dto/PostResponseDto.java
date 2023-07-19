package com.example.springbackoffice.dto;

import com.example.springbackoffice.entity.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostResponseDto {
    private Long id;
    private String title;
    private String contents;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private Long user_id;
    private String username;
    private String userNickName;
    private List<CommentResponseDto> commentResponseDtoList;
    private Integer post_like_count;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.created_at = post.getCreated_at();
        this.modified_at = post.getModified_at();
        this.post_like_count = post.getPost_like_count();
        this.user_id = post.getUser().getId();
        this.username = post.getUser().getName();
        this.userNickName = post.getUser().getNickname();
        if(post.getCommentList().size()>0) {
            this.commentResponseDtoList = new ArrayList<>();
            for (Comment comment : post.getCommentList()) {
                this.commentResponseDtoList.add(new CommentResponseDto(comment));
            }
            // getComments를 통해 저장된 post의 commentList의 comment들을
            // PostResponseDto의 commentResponseDtoList에 복사하는 과정
        }
    }
}

