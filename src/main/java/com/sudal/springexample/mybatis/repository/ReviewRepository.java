package com.sudal.springexample.mybatis.repository;

import com.sudal.springexample.mybatis.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewRepository {

    // new_review 테이블의 id가 14인 행 조회 (1행이기 때문에 List<Review>가 아닌 Review임)
    //public Review selectReview();

    public Review selectReview(@Param("id") int id);
}
