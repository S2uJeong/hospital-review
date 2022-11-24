package com.hospital.review.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter
public class ReviewCreateResponse {

    private String userName;
    private String title;
    private String content;
    private String message; // 요청 처리가 잘 됐는지 확인하는 문자열 추가
}
