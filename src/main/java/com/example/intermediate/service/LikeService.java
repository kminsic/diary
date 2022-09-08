package com.example.intermediate.service;

import com.example.intermediate.domain.Member;
import com.example.intermediate.domain.Post;
import com.example.intermediate.domain.PostLike;
import com.example.intermediate.jwt.TokenProvider;
import com.example.intermediate.repository.CommentRepository;
import com.example.intermediate.repository.LikeRepository;
import com.example.intermediate.repository.PostRepository;
import com.example.intermediate.controller.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    private final TokenProvider tokenProvider;

    private final LikeRepository likeRepository;



    //like 신기능
    public PostLike isPresentLikes(Long Id, String nickname) {
        Optional<PostLike> optionalPostLikes = likeRepository.findByRequestIdAndNickname(Id,nickname);
        return optionalPostLikes.orElse(null);
    }

    //라이크 기능 - 포스팅에
    @Transactional
    public ResponseDto<?> createpostlikes(Long id, HttpServletRequest request) {
        if (null == request.getHeader("RefreshToken")) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "로그인이 필요합니다.");
        }

        if (null == request.getHeader("Authorization")) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "로그인이 필요합니다.");
        }

        Member member = validateMember(request);
        if (null == member) {
            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
        }

        Post post = isPresentPost(id);
        if (null == post) {
            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 게시글 id 입니다.");
        }
        PostLike likes = isPresentLikes(post.getId(), member.getNickname());

        if (null == likes)
            likeRepository.save(PostLike.builder()
                    .requestId(post.getId())
                    .nickname(member.getNickname()).build());
        else
            likeRepository.delete(likes);

        post.updatelikes(likeRepository
                .findAllByRequestId(post.getId()).size());

        return ResponseDto.success("like success");

    }




    @Transactional(readOnly = true)
    public Post isPresentPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElse(null);
    }





    @Transactional
    public Member validateMember(HttpServletRequest request) {
        if (!tokenProvider.validateToken(request.getHeader("RefreshToken"))) {
            return null;
        }
        return tokenProvider.getMemberFromAuthentication();
    }
}
