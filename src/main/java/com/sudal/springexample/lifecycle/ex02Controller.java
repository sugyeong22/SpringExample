package com.sudal.springexample.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ex02Controller {

    @RequestMapping("/lifecycle/ex02")
        public String thymeleafResponse(){
            // 응단에 담을 html 경로
            // src/main/resources/templates 생략
            // .html 생략
            return"Lifecycle/ex.02";
        }
}
