package com.group.libarayapp.repository.task06;

import com.group.libarayapp.dto.task06.request.FruitCreateRequestEx06;
import com.group.libarayapp.dto.task06.request.FruitRequestEx06;
import com.group.libarayapp.dto.task06.response.FruitResponseEx06;

public interface FruitRepositoryEx06 {
    void saveFruit(FruitRequestEx06 fruitRequestEx06);
    void salesQuantityFruit(FruitCreateRequestEx06 fruitCreateRequestEx06);
    boolean isSalesFruitNotExist(FruitCreateRequestEx06 fruitCreateRequestEx06);
    FruitResponseEx06 salesAmountFruit(String name);
}
