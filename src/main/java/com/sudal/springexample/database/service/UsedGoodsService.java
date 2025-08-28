package com.sudal.springexample.database.service;

import com.sudal.springexample.database.domain.UsedGoods;
import com.sudal.springexample.database.rapository.UsedGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 부가적인 기능을 수행
// Controller에서 필요한 기능 수행
@Service
public class UsedGoodsService {

    // 의존성 주입 - DI (Dependence Injection)
    // 객체 생성을 Spring framework에서 직접 관리
    @Autowired // 객체가 알아서 관리됌.
    private UsedGoodsRepository usedGoodsRepository;

    // 중고거래 게시글 정보를 얻어오기
    public List<UsedGoods> getUsedGoodsList(){

        // used_goods 테이블 모든 행 조회
        List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();

        return usedGoodsList;

    }
}
