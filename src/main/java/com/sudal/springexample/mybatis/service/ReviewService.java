package com.sudal.springexample.mybatis.service;

import com.sudal.springexample.mybatis.domain.Review;
import com.sudal.springexample.mybatis.repository.ReviewRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // id가 14인 리뷰 정보 얻어오기
    public Review getReview(int id) {

        Review review = reviewRepository.selectReview(id);

        return review;
    }
}
