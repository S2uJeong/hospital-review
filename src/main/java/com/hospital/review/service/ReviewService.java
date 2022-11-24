package com.hospital.review.service;

import com.hospital.review.domain.Hospital;
import com.hospital.review.domain.Review;
import com.hospital.review.domain.dto.ReviewCreateRequest;
import com.hospital.review.domain.dto.ReviewCreateResponse;
import com.hospital.review.repository.HospitalRepository;
import com.hospital.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;
    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }
    public ReviewCreateResponse createReview(ReviewCreateRequest dto) {
        // 1. review를 만들기 전, hospitalId를 기준으로 값이 있는지 체킹해주는 기능을 추가해준다.
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(dto.getHospitalId());
        // 2. 매개변수로 받은 dto를 review로 변환한다.  - reviewEntity 만들기
        Review review = Review.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .userName(dto.getUserName())
                .hospital(hospitalOptional.get())
                .build();
        // 3. repository (서버)에 응답을 저장한다.
        Review savedReview = reviewRepository.save(review);

        return ReviewCreateResponse.builder()
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .userName(savedReview.getUserName())
                .message("리뷰 등록 성공")
                .build();
    }
}
