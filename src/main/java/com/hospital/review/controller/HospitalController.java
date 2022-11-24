package com.hospital.review.controller;

import com.hospital.review.domain.dto.ReviewCreateRequest;
import com.hospital.review.domain.dto.ReviewCreateResponse;
import com.hospital.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controllor는 단지 요청만 받고 그 요청을 서비스로 보내주고,
 * 서비스에서 리턴한 것을 다시 사용자 유저에게 뿌려준다.
 */
@RestController
@RequestMapping("/api/v1/hospitals")
@Slf4j
public class HospitalController {

    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> add(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        log.info("{}", reviewCreateRequest); // reviewCreateRequest 가 잘들어왔는지 확인
        return ResponseEntity.ok().body(reviewService.createReview(reviewCreateRequest));
    }
}
