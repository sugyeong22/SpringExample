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

        public int createUserByObject(User user) {
            int count = userRepository.insertUserByObject(user);

            return count;
        }

        // 가장 최근에 등록한 사용자 정보 얻어오기
        public User getLastUser(){
            User lastUser = userRepository.selectLastUser();
            return lastUser;
        }

        // 전달받은 email과 중복되었는지 여부 확인 기능
        public boolean isDuplicateEmail(String email){
            int count = userRepository.selectCountByEmail(email);

            if(count > 0){
                return true;
            } else{
                return false;
            }

        }


    }
