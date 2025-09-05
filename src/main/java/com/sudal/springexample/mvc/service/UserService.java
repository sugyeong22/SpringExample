package com.sudal.springexample.mvc.service;

import com.sudal.springexample.mvc.domian.User;
import com.sudal.springexample.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

        public int creatUser(
               String name
                , String birthday
                , String email
                , String introduce
        ){
            int count = userRepository.inserUser(name, birthday, email, introduce );
            return count;
        }

        // 가장 최근에 등록한 사용자 정보 얻어오기
        public User getLastUser(){
            User lastUser = userRepository.selectLastUser();
            return lastUser;
        }


    }
