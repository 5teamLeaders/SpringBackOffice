package com.example.springbackoffice.entity;

import com.example.springbackoffice.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body; // 댓글 본문

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; //게시글과 연관 관계

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 글쓴이와 연관 관계

    public Comment(CommentRequestDto commentRequestDto, User user, Post post) {
        this.body = commentRequestDto.getBody();
        this.user = user;
        this.post = post;
    }
}