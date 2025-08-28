package com.sudal.springexample.mybatis;

import com.sudal.springexample.mybatis.domain.Review;
import com.sudal.springexample.mybatis.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class reviewController {

    @Autowired
    private ReviewService reviewService;

//    private final ReviewService reviewService;
//
    // id가 14인 리뷰 정보를 response에 json으로 담는 페이지
    @ResponseBody
    @RequestMapping("/mybatis/review")
    public Review review(@RequestParam("id") int id) {

        // id가 14인 리뷰 정보 얻어오기
        Review review = reviewService.getReview(id);

        return review;
    }
}

