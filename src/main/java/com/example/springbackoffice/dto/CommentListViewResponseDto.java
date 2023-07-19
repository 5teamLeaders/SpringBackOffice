//package com.example.springbackoffice.dto;
//
//import com.example.springbackoffice.entity.Comment;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//
//import java.time.LocalDateTime;
//
//@Controller
//@RequiredArgsConstructor
//public class CommentListViewResponseDto {
//
//    private String contents; // 본문
//    private String username;
//    private LocalDateTime created_at;
//    private LocalDateTime modified_at;
//    private Long id;
//
//    public CommentListViewResponseDto(Comment comment) {
//        super();
//
//        this.id = comment.getId();
//        this.contents = comment.getContents();
//        this.username = comment.getUser().getUsername();
//        this.created_at =comment.getPost().getCreated_at();
//        this.modified_at = comment.getPost().getModified_at();
//    }
//}
