package com.group.libarayapp.service.task07;

import com.group.libarayapp.domain.user.task07.Fruit;
import com.group.libarayapp.domain.user.task07.FruitRepositoryEx07;
import com.group.libarayapp.dto.task07.request.FruitCreateRequestEx07;
import com.group.libarayapp.dto.task07.request.FruitRequestEx07;
import com.group.libarayapp.dto.task07.response.FruitResponseEx07;
import com.group.libarayapp.dto.task07.response.FruitSalesCountResponseEx07;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceEx07 {

    private final FruitRepositoryEx07 fruitRepositoryEx07;

    public FruitServiceEx07(FruitRepositoryEx07 fruitRepositoryEx07) {
        this.fruitRepositoryEx07 = fruitRepositoryEx07;
    }

    public void saveFruit(FruitRequestEx07 request) {
        fruitRepositoryEx07
                .save(new Fruit(
                        request.getName(),
                        request.getWarehousingDate(),
                        request.getPrice(),
                        request.getSalesQuantity()
                ));
    }

    public void salesQuantityFruit(FruitCreateRequestEx07 request) {
        Fruit fruit = fruitRepositoryEx07.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        fruit.updateSalesQuantity(fruit.getSalesQuantity());

        fruitRepositoryEx07.save(fruit);
    }

    public FruitResponseEx07 salesAmountFruit(String name) {
        Fruit fruit = fruitRepositoryEx07.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        long salesAmount = fruitRepositoryEx07
                .findFruitByNameAndSalesQuantityEquals(fruit.getName(), 0)
                .stream().mapToLong(Fruit::getPrice).sum();

        long notSalesAmount = fruitRepositoryEx07
                .findFruitByNameAndSalesQuantityEquals(fruit.getName(), 1)
                .stream().mapToLong(Fruit::getPrice).sum();

        return new FruitResponseEx07(salesAmount, notSalesAmount);
    }

    public FruitSalesCountResponseEx07 salesCountFruit(String name) {
        List<Fruit> fruitByNameAndSalesQuantityEquals = fruitRepositoryEx07.findFruitByNameAndSalesQuantityEquals(name, 1);
        return new FruitSalesCountResponseEx07(fruitByNameAndSalesQuantityEquals.size());
    }

    public List<Fruit> fruitListOfGTEorLTE(String option, Long price) {
        if (option.equals("GTE")) {
            return fruitRepositoryEx07.
                    findFruitByPriceGreaterThanEqualAndSalesQuantityEquals(price, 0);
        } else if (option.equals("LTE")) {
            return fruitRepositoryEx07
                    .findFruitByPriceLessThanEqualAndSalesQuantityEquals(price, 0);
        }

        return null;
    }
}
