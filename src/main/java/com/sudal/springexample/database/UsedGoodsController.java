package com.sudal.springexample.database;

import com.sudal.springexample.database.domain.UsedGoods;
import com.sudal.springexample.database.service.UsedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//Request, Response 처리 담당
@Controller
public class UsedGoodsController {

    @Autowired
    private UsedGoodsService usedGoodsService;

    // 중고 거래 게시글 모든 정보를 response에 담는다.
    @RequestMapping("/db/usedgoods/list")
    @ResponseBody
    public List<UsedGoods> usedGoodsList(){
        // 중고 거래 게시글 정보 얻어오기
        List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();

        return usedGoodsList;




    }
}
