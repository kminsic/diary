package com.example.intermediate.controller.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyPageResponseDto {
    private List<PostResponseDto> postResponseDtoList;
    private List<CommentResponseMyPageDto> commentResponseMyPageDtoList;
    private List<SubCommentResponseMyPageDto> subCommentResponseMyPageDtoList;
}
