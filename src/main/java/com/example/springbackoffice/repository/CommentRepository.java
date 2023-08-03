package com.example.springbackoffice.repository;

import com.example.springbackoffice.entity.Comment;
import com.example.springbackoffice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByUser (User user);
}
