package com.sudal.springexample.thymleaf;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RequestMapping("/thymelaef")
@Controller
public class ThymeleafController {

    @GetMapping("/ex01")
    public String ex01(){
        return "thymeleaf/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(Model model){

        List<String> fruitList = new ArrayList<>();

        fruitList.add("apple");
        fruitList.add("banana");
        fruitList.add("orange");

        model.addAttribute("fruitList", fruitList);

        // 사용자 정보 리스트
        // 이름, 나이, 취미
        // {"name" : "김인규", "age" : 21, "hobby" : "독서"}

        List<Map<String,Object>> userList = new ArrayList<>();
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("name","김인규");
        userMap.put("age", 21);
        userMap.put("hobby","독서");
        userList.add(userMap);

        userMap = new HashMap<>();
        userMap.put("name","바다");
        userMap.put("age", 7);
        userMap.put("hobby","사냥하기");
        userList.add(userMap);

        model.addAttribute("userList", userList);


        return "thymeleaf/ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model){

        Date date = new Date(); // 객체가 생성된 현재 시간

        LocalDate localDate = LocalDate.now(); // 현재 날짜를 리턴

        LocalDateTime localDateTime = LocalDateTime.now(); //현재 날짜시간

        model.addAttribute("date", date);
        model.addAttribute("localDate", localDate);
        model.addAttribute("localDateTime", localDateTime);


        return "thymeleaf/ex03";
    }
}
