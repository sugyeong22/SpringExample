package com.sudal.springexample.ajax;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

public class ajaxController {

    // response에 데이터(JSON)를 담는 페이지
    // API <--> View(HTML)
    // API : 요청에 대한 응답을 순수한 데이터만 담기는 형식
    // 이름과 생년월일을 전달 받고, 이름과 나이를 JSON으로 응답에 담는다.

    @ResponseBody // 내용물을 그대로 넣고, 메세지 컨버터가 알아서 반환.
    @GetMapping("/ajax/person")
    public Map<String, Object> personInfo(
            @RequestParam("name") String name
            , @RequestParam("birthday") String birthday) {  // 20020412

        int year = Integer.parseInt(birthday.substring(0, 4));
        int age = 2025 - year + 1;

        // {"name":"김인규", "age":27}
        Map<String, Object> personMap = new HashMap<>();
        personMap.put("name", name);
        personMap.put("age", age);

        return personMap; // API (데이터의 응답을 확인하는 페이지)
    }

    @GetMapping("/ajax/ex01")
    public String ex01() {
        return "ajax/ex01"; // 뷰페이지 (사용자가 보는)
    }
}
