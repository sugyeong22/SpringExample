package com.sudal.springexample.database.rapository;

import com.sudal.springexample.database.domain.UsedGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsedGoodsRepository {

    // used_goods 테이블 모든행 조회
    public List<UsedGoods> selectUsedGoodsList();

}
