package com.group.libarayapp.service.task06;

import com.group.libarayapp.dto.task06.request.FruitCreateRequestEx06;
import com.group.libarayapp.dto.task06.request.FruitRequestEx06;
import com.group.libarayapp.dto.task06.response.FruitResponseEx06;
import com.group.libarayapp.repository.task06.FruitRepositoryEx06;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceEx06 {

    private final FruitRepositoryEx06 fruitRepositoryEx06;

    public FruitServiceEx06(FruitRepositoryEx06 fruitRepositoryEx06) {
        this.fruitRepositoryEx06 = fruitRepositoryEx06;
    }

    public void saveFruit(FruitRequestEx06 request) {
        fruitRepositoryEx06.saveFruit(request);
    }

    public void salesQuantityFruit(FruitCreateRequestEx06 request) {
        if (fruitRepositoryEx06.isSalesFruitNotExist(request)) {
            throw new IllegalArgumentException();
        }
        fruitRepositoryEx06.salesQuantityFruit(request);
    }

    public FruitResponseEx06 salesAmountFruit(String name) {
        return fruitRepositoryEx06.salesAmountFruit(name);
    }
}
