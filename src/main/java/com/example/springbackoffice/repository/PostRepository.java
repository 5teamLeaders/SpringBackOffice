package com.example.springbackoffice.repository;

import com.example.springbackoffice.entity.Post;
import com.example.springbackoffice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
    List<Post> findAllByUser (User user);
}
