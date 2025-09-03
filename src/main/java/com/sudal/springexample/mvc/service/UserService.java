package com.sudal.springexample.mvc.service;

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
    }
