package com.sudal.springexample.ajax;

import com.sudal.springexample.mvc.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {

    @Autowired
    private UserService userService;

    //사용자 추가 API
    @ResponseBody
    @PostMapping("/add")
    public Map<String, String> addUser(
            @RequestParam("name") String name
            , @RequestParam("birthday") String birthday
            , @RequestParam("email") String email
            , @RequestParam("introduce") String introduce) {

        int count = userService.creatUser(name, birthday, email, introduce);

        // 성공 {"result":"success"}
        // 실패 {"result":"fail"}
        Map<String, String> resultMap = new HashMap<>();

        if(count == 1) {
            //성공
            resultMap.put("result", "success");
        } else {
            // 실패
            resultMap.put("result", "fail");
        }

        return resultMap;
    }

    // 이메일 중복확인 API
    @ResponseBody
    @GetMapping("/duplicate-email")
    public Map<String, Boolean>isDuplicateEmail(@RequestParam("email") String email){

        // 증복 됨 {"isDuplicate" : true}
        // 중복 안됨 {"isDuplicate" : false}
        Map<String,Boolean> resultMap = new HashMap<>();

        // 특정 email이 이미 가입된 정보가 있는지 확인
        if(userService.isDuplicateEmail(email)){
            resultMap.put("isDuplicate",true);
        } else{
            resultMap.put("isDuplicate",false);
        }
        return resultMap;
    }

    @GetMapping("/form")
    public String userForm(){
        return "ajax/userForm";
    }
}
