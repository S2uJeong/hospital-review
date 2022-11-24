package com.hospital.review.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review {
    @Id
    private Long id;
    private String title;
    private String content;
    private String userName;
    // 매핑을 위한 부분
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
