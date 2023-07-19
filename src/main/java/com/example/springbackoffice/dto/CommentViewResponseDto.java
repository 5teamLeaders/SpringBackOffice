//package com.example.springbackoffice.dto;
//
//import com.example.springbackoffice.entity.Comment;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@NoArgsConstructor
//public class CommentViewResponseDto extends ApiResponseDto{
//
//    private String contens; // 본문
//    private String userName;
//    private LocalDateTime created_at;
//    private LocalDateTime modified_at;
//    private Long post_id;
//
//    public CommentViewResponseDto(Comment comment) {
//        super();
//
//        this.post_id = comment.getId();
//        this.contens = comment.getContents();
//        this.userName = comment.getUser().getUsername();
//        this.created_at =comment.getPost().getCreated_at();
//        this.modified_at = comment.getPost().getModified_at();
//    }
//}
