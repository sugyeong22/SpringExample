package com.sudal.springexample.database;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Request, Response 처리 담당
@Controller
public class UsedGoodsController {

    // 중고 거래 게시글 모든 정보를 response에 담는다.
    @RequestMapping("/db/usedgoods/list")
    public usedGoodsList(){
        // 중고 거래 게시글 정보 얻어오기


    }
}
