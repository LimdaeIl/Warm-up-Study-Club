package com.group.libarayapp.repository.task06;

import com.group.libarayapp.dto.task06.request.FruitCreateRequestEx06;
import com.group.libarayapp.dto.task06.request.FruitRequestEx06;
import com.group.libarayapp.dto.task06.response.FruitResponseEx06;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FruitMemoryRepositoryEx06 implements FruitRepositoryEx06 {
    @Override
    public void saveFruit(FruitRequestEx06 fruitRequestEx06) {

    }

    @Override
    public boolean isSalesFruitNotExist(FruitCreateRequestEx06 fruitCreateRequestEx06) {
        return false;
    }

    @Override
    public void salesQuantityFruit(FruitCreateRequestEx06 fruitCreateRequestEx06) {

    }

    @Override
    public FruitResponseEx06 salesAmountFruit(String name) {
        return new FruitResponseEx06(List.of(), List.of());
    }
}
