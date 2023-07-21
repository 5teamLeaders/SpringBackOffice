package com.example.springbackoffice.controller;

import com.example.springbackoffice.dto.CommentResponseDto;
import com.example.springbackoffice.dto.PostResponseDto;
import com.example.springbackoffice.security.UserDetailsImpl;
import com.example.springbackoffice.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostViewController {
    private final PostService postService;
    @GetMapping("/post/view/{id}")
    public String getPost(@PathVariable Long id,
                          Model model,
                          @AuthenticationPrincipal UserDetailsImpl userDetails) {
        PostResponseDto responseDto = postService.lookupPost(id);
        List<CommentResponseDto> responseCommentId = responseDto.getPostCommentList();
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUser().getUsername());
        }
        model.addAttribute("post", responseDto);
        model.addAttribute("comment",responseCommentId);

        return "detailPost";
    }

    @GetMapping("/post/modify")
    public String modifyPostView(@RequestParam Long id,
                                 Model model,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {

        model.addAttribute("info_username",userDetails.getUser().getUsername());
        model.addAttribute("info_post",postService.lookupPost(id));

        return "modifyPost";
    }

    @GetMapping("/post/write")
    public String createPostView(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("info_username", userDetails.getUser().getUsername());
        return "writePost";
    }
}
