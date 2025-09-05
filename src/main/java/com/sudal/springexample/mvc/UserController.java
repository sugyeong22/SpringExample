package com.sudal.springexample.mvc;

import com.sudal.springexample.mvc.domian.User;
import com.sudal.springexample.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mvc/user")
public class UserController {

    @Autowired
    UserService userService;

    //@RequestMapping(value="/add", method= HttpMethod.GET)
    //@RequestMapping(value="/add", method= HttpMethod.POST)
    @PostMapping("/add")
    public String addUser(
            @RequestParam("name") String name
            , @RequestParam("birthday")String birthday
            , @RequestParam("email")String email
            , @RequestParam(value="introduce", required=false)String introduce) { // 기본설정은 required=true라서 값이 없으면 안됌. 값을 안받아도 되는거면 false로 설정

        int count = userService.creatUser(name, birthday, email, introduce);
        return "실행결과 : " + count;
    }


    @GetMapping("/form")
    public String userForm(){
        return "mvc/userForm";
    }

    @GetMapping("/info")
    public String userInfo(Model model){

        // 가장 최근 등록된 사용자 정보 얻어오기
        User lastUser = userService.getLastUser();
        model.addAttribute("title","가장 최근에 등록된 사용자 정보");
        model.addAttribute("result",lastUser);
        return "mvc/userInfo";
    }





    }



