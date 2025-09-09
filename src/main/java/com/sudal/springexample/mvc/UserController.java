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
            , @RequestParam("birthday") String birthday
            , @RequestParam("email") String email
            , @RequestParam(value="introduce", required=false) String introduce
            , Model model) {

        //객체를 저장해서 전달하면, id를 전달 할 수 있음.
        User user = new User();
        user.setName(name);
        user.setYyyymmdd(birthday);
        user.setEmail(email);
        user.setIntroduce(introduce);

        int count = userService.createUserByObject(user);

//        int count = userService.createUser(name, birthday, email, introduce);
        model.addAttribute("result", user);
//        return "실행 결과 : " + count;
        return "mvc/userInfo";
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



