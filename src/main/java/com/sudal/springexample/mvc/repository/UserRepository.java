package com.sudal.springexample.mvc.repository;

import com.sudal.springexample.mvc.domian.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;

@Mapper
public interface UserRepository {

    public int inserUser(
             @Param("name")String name
            ,@Param("birthday")String birthday
            ,@Param("email") String email
            ,@Param("introduce")String introduce
    );

    public int insertUserByObject(User user);

    public User selectLastUser();
}
