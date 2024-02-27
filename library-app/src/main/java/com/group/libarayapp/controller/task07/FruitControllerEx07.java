package com.group.libarayapp.controller.task07;

import com.group.libarayapp.domain.user.task07.Fruit;
import com.group.libarayapp.dto.task07.request.FruitCreateRequestEx07;
import com.group.libarayapp.dto.task07.request.FruitRequestEx07;
import com.group.libarayapp.dto.task07.response.FruitResponseEx07;
import com.group.libarayapp.dto.task07.response.FruitSalesCountResponseEx07;
import com.group.libarayapp.service.task07.FruitServiceEx07;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitControllerEx07 {

    private final FruitServiceEx07 fruitServiceEx07;

    public FruitControllerEx07(FruitServiceEx07 fruitServiceEx07) {
        this.fruitServiceEx07 = fruitServiceEx07;
    }

    // 문제 1
    @PostMapping("/api/v3/fruit")
    public void saveFruit(@RequestBody FruitRequestEx07 request) {
        fruitServiceEx07.saveFruit(request);
    }


    // 문제 2
    @PutMapping("/api/v3/fruit")
    public void salesQuantityFruit(@RequestBody FruitCreateRequestEx07 request) {
        fruitServiceEx07.salesQuantityFruit(request);
    }

    // 문제 3
    @GetMapping("/api/v3/fruit/stat")
    public FruitResponseEx07 SalesAmountFruit(@RequestParam String name) {
        return fruitServiceEx07.salesAmountFruit(name);
    }

    // 문제 3
    @GetMapping("/api/v3/fruit/count")
    public FruitSalesCountResponseEx07 SalesCountFruit(@RequestParam String name) {
        return fruitServiceEx07.salesCountFruit(name);
    }

    @GetMapping("/api/v3/fruit/list")
    public List<Fruit> fruitListOfGTEorLTE(
            @RequestParam(name = "option") String option,
            @RequestParam(name = "price") long price) {
        return fruitServiceEx07.fruitListOfGTEorLTE(option, price);
    }

}
