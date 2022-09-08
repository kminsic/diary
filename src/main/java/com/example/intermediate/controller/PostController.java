package com.example.intermediate.controller;

import com.example.intermediate.controller.request.PostRequestDto;
import com.example.intermediate.controller.response.ResponseDto;
import com.example.intermediate.service.LikeService;
import com.example.intermediate.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final LikeService likeService;
    private final PostService postService;


    // 게시글 작성
    @PostMapping("/api/auth/posts")
    public ResponseDto<?> createPost(@RequestPart(value = "content") PostRequestDto requestDto,
                                     @RequestPart(value = "image", required = false) MultipartFile file,
                                     HttpServletRequest request) {
        return postService.createPost(requestDto, request, file);
    }

    // 상세 게시글 가져오기
    @GetMapping("/api/posts/{id}")
    public ResponseDto<?> getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // 전체 게시글 가져오기
    @GetMapping("/api/posts")
    public ResponseDto<?> getAllPosts() {
        return postService.getAllPost();
    }

    // 게시글 수정
    @PutMapping("/api/auth/posts/{id}")
    public ResponseDto<?> updatePost(@PathVariable Long id,
                                     @RequestPart(value = "content", required = false) PostRequestDto requestDto,
                                     @RequestPart(value = "image", required = false) MultipartFile file,
                                     HttpServletRequest request) {
        return postService.updatePost(id, requestDto, file, request);
    }

    //게시글 삭제
    @DeleteMapping("/api/auth/posts/{id}")
    public ResponseDto<?> deletePost(@PathVariable Long id,
                                     HttpServletRequest request) {
        return postService.deletePost(id, request);
    }

    // 테스트
    @DeleteMapping("/api/posts/organize/{id}")
    public String organizePost(@PathVariable Long id) {
        postService.organize(id);
        return "scheduler completed";
    }

    //라이크 신기능
    @PostMapping("/api/auth/posts/likes/{id}")
    ResponseDto<?> createpostlikes(@PathVariable Long id,
                                   HttpServletRequest request){
        return likeService.createpostlikes(id,request);
    }
}
